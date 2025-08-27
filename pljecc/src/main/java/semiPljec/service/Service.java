package semiPljec.service;

import semiPljec.repository.Repository;
import semiPljec.user.*;

import java.util.ArrayList;
import java.util.Scanner;

//실제 비즈니스 로직 처리 (회원가입, 로그인, 수정, 삭제 등)
public class Service {
//    private final Repository repository = new Repository();

    private final Repository repository;

    public Service() {
        repository = new Repository();
    }

    public void fineAllMembers() {
        ArrayList<Member> result = repository.findAllMembers();
        if(!result.isEmpty()){
            System.out.println("Service에서 조회 확인 : ");

            for (Member member : result) {
                System.out.println("member : "+ member);
            }
        }else{
            System.out.println("해당 사이트에 회원 없음");
        }
    }
//회원가입 중복검사 (닉네임, 이메일, 전화번호)
    public void registMember(Member newMember) {

        //회원 활성화 상태 추가
        newMember.setAccountStatus((AccountStatus.ACTIVE));

        //중복체크
            if(repository.isIdExists(newMember.getId())){
                System.out.println("이미 존재하는 아이디입니다.");
                return;
            }

            if(repository.isNicknameExists(newMember.getNickname())){
                System.out.println("이미 존재하는 닉네임입니다.");
                return;
            }

            if(repository.isEmailExists(newMember.getEmail())){
                System.out.println("이미 존재하는 이메일입니다.");
                return;
            }
            if(repository.isPhoneExists(newMember.getPhone())){
                System.out.println("이미 존재하는 전화번호입니다.");
                return;
            }
        // 중복 없을때만 저장 진행, 순서 중요함, 위에 해당 코드 썼었으면 저장한 상태에서 검사->항상 이미 존재하는 아이디라 뜸
        int result = repository.registMember(newMember); // 회원가입

            if(result == 1){
                System.out.println("회원가입 성공!");
            System.out.println(newMember.getId()+"회원님 환영합니다!");
        }else{
            System.out.println("회원 가입 실패");
        }
    }

    public void findMember(String id) {
        Member findMember = repository.findMember(id);
        if(findMember != null){ // 회원 조회 되는 경우
            System.out.println("회원 조회 성공 : " + findMember);
        }else{
            System.out.println("회원 조회가 되지 않습니다.");
        }
    }

    public Member fineMemberForModify(String id) {
        Member selectMember = repository.findMember(id);
        Member copyMember = null;
        if(selectMember != null){
            copyMember = new Member();
            copyMember.setMemNo(selectMember.getMemNo());
            copyMember.setId(selectMember.getId());
            copyMember.setPwd(selectMember.getPwd());
            copyMember.setNickname(selectMember.getNickname());
            copyMember.setEmail(selectMember.getEmail());
            copyMember.setPhone(selectMember.getPhone());
            copyMember.setRecommendMenus(selectMember.getRecommendMenus());
            copyMember.setAccountStatus(selectMember.getAccountStatus());

        }else {
            System.out.println("그런 회원은 없네요");
        }
        return copyMember;
    }

    public void modifyMember(Member modifyMember) {
        int result = repository.modifyMember(modifyMember);
        if (result > 0) {
            System.out.println(modifyMember.getId() + "회원님의 정보가 수정되었습니다.");
        } else {
            System.out.println("회원 정보 수정이 실패하였습니다.");
        }
    }

    public void removeMember(String memId) {
        int result = repository.removeMember(memId);

        if (result > 0) {
            System.out.println("회원님 그동안 감사했습니다.");
        }else{
            System.out.println("회원탈퇴 실패");
        }
    }

    public void signUp() {
        Scanner sc = new Scanner(System.in);
        Member newMember = new Member();

        System.out.print("아이디 입력: ");
        String id = sc.nextLine();
        if(repository.isIdExists(id)) {
            System.out.println("이미 존재하는 아이디입니다.");
            return;
        }
        newMember.setId(id);

        // 닉네임
        System.out.print("닉네임 입력: ");
        String nickname = sc.nextLine();
        if(repository.isNicknameExists(nickname)) {
            System.out.println("이미 존재하는 닉네임입니다.");
            return;
        }
        newMember.setNickname(nickname);

        // 이메일
        System.out.print("이메일 입력: ");
        String email = sc.nextLine();
        if(repository.isEmailExists(email)) {
            System.out.println("이미 존재하는 이메일입니다.");
            return;
        }
        newMember.setEmail(email);

        // 전화번호
        System.out.print("전화번호 입력: ");
        String phone = sc.nextLine();
        if(repository.isPhoneExists(phone)) {
            System.out.println("이미 존재하는 전화번호입니다.");
            return;
        }
        newMember.setPhone(phone);

        // 회원 번호 & 상태
        int lastNo = repository.findLastMemberNo();
        newMember.setMemNo(lastNo + 1);
        newMember.setAccountStatus(AccountStatus.ACTIVE);

        // 저장
        int result = repository.registMember(newMember);
        if(result == 1) {
            System.out.println(newMember.getId() + " 회원님 환영합니다!");
        } else {
            System.out.println("회원 가입 실패");
        }
    }

    public void menuCategory() {
        Scanner sc = new Scanner(System.in);
        int nationChoice;


        do {
            System.out.println("추천 받을 나라를 선택하세요:");
            System.out.println("1. 한식");
            System.out.println("2. 중식");
            System.out.println("3. 일식");
            System.out.println("4. 양식");
            System.out.println("5. 동남아");
            System.out.println("0. 종료");

            nationChoice = sc.nextInt();

            switch (nationChoice) {
                case 1:
                    System.out.println("오늘의 추천 한식: " + KoreanMenu.getRandomMenu().getKoreanName());
                    break;
                case 2:
                    System.out.println("오늘의 추천 중식: " + ChineseMenu.getRandomMenu().getKoreanName());
                    break;
                case 3:
                    System.out.println("오늘의 추천 일식: " + JapaneseMenu.getRandomMenu().getKoreanName());
                    break;
                case 4:
                    System.out.println("오늘의 추천 양식: " + WesternMenu.getRandomMenu().getKoreanName());
                    break;
                case 5:
                    System.out.println("오늘의 추천 동남아 음식: " + SoutheastAsianMenu.getRandomMenu().getKoreanName());
                    break;
                case 0:
                    System.out.println("추천 메뉴 프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못 선택했습니다.");
            }

            if (nationChoice != 0) {
                System.out.println("\n다시 추천을 받으시겠습니까? (계속하려면 1, 종료하려면 0)");
                int continueChoice = sc.nextInt();
                if (continueChoice == 0) {
                    nationChoice = 0;
                    System.out.println("추천 메뉴 프로그램을 종료합니다.");
                }
            }

        } while (nationChoice != 0);

        // sc.close(); // Service 클래스에서는 닫지 않는 게 안전
    }
}


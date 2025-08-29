package semiPljec.service;

import semiPljec.menu.*;
import semiPljec.repository.MemberRepository;
import semiPljec.repository.MenuRepository;
import semiPljec.user.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//실제 비즈니스 로직 처리 (회원가입, 로그인, 수정, 삭제 등)
public class MemberService {
//    private final Repository repository = new Repository();

    private final MemberRepository repository;
    private final MenuRepository menuRepository;

    public MemberService() {
        repository = new MemberRepository();
        menuRepository = new MenuRepository();
    }

// Repository에서 모든 회원 조회 -> 출력
    public void findAllMembers() {
        ArrayList<Member> result = repository.findAllMembers();
        if(!result.isEmpty()){
            System.out.println("====모든 회원 정보 조회====");

            for (Member member : result) {
                System.out.println("member : "+ member);
            }
        }else{
            System.out.println("해당 사이트에 회원 없음");
        }
    }
    //회원가입 중복검사 (닉네임, 이메일, 전화번호)
    //기존 회원 가입용 메서드, 중복 체크 + 상태 설정 후 저장
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

    //특정 ID 회원 조회 -> 출력
    public void findMember(String id) {
        Member findMember = repository.findMember(id);
        if(findMember != null){ // 회원 조회 되는 경우
            System.out.println("회원 조회 성공 : " + findMember);
        }else{
            System.out.println("회원 조회가 되지 않습니다.");
        }
    }


    //수정용 회원 조회, 조회 성공 시 Member객체 복사본 생성 ->UI에서 수정 후 다시 service전달
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


    //Repository에서 회원 정보 수정
    public void modifyMember(Member modifyMember) {
        int result = repository.modifyMember(modifyMember);
        if (result > 0) {
            System.out.println(modifyMember.getId() + "회원님의 정보가 수정되었습니다.");
        } else {
            System.out.println("회원 정보 수정이 실패하였습니다.");
        }
    }
    //Repository에서 회원 삭제
    public void removeMember(String memId) {
        int result = repository.removeMember(memId);

        if (result > 0) {
            System.out.println("회원님 그동안 감사했습니다.");
        }else{
            System.out.println("회원탈퇴 실패");
        }
    }

    //Scanner로 회원 정보 입력
    //중복 체크(ID, 닉네임, 이메일, 전화번호)
    //회원 번호 자동 증가, 상대 ACTIVE설정, Repository에 저장
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

        System.out.print("비밀번호 입력 : ");
        String pwd = sc.nextLine();
        if(repository.isPwdExists(pwd)){
            System.out.println("사용하실 비밀번호를 입력해주세요.");
        }
        newMember.setPwd(pwd);


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

    //메뉴 추천 관련, Scanner로 나라 선택
    //각 나라별 Menu클래스에서 랜덤 메뉴 추천
    public void menuCategory() {
        Scanner sc = new Scanner(System.in);
        int nationChoice;


        do {
            System.out.println("메뉴 추천 받을 나라를 선택하세요:");
            System.out.println("1. 한식");
            System.out.println("2. 중식");
            System.out.println("3. 일식");
            System.out.println("4. 양식");
            System.out.println("5. 동남아");
            System.out.println("9. 지금까지 추천받은 메뉴 조회하기");
            System.out.println("0. 종료");

            nationChoice = sc.nextInt();
            sc.nextLine(); //버퍼 정리

            String menuName = null;

            switch (nationChoice) {
                case 1:
                    menuName = KoreanMenu.getRandomMenu().getKoreanName();
                    System.out.println("오늘의 추천 한식: " + menuName);
                    break;
                case 2:
                    menuName = ChineseMenu.getRandomMenu().getKoreanName();
                    System.out.println("오늘의 추천 중식: " + menuName);
                    break;
                case 3:
                    menuName = JapaneseMenu.getRandomMenu().getKoreanName();
                    System.out.println("오늘의 추천 일식: " + menuName);
                    break;
                case 4:
                    menuName = WesternMenu.getRandomMenu().getKoreanName();
                    System.out.println("오늘의 추천 양식: " + menuName);
                    break;
                case 5:
                    menuName = SoutheastAsianMenu.getRandomMenu().getKoreanName();
                    System.out.println("오늘의 추천 동남아 음식: " + menuName);
                    break;
                case 9:
                    List<RecommendMenu> allMenus = menuRepository.findAll(); // 지금까지 저장된 모든 메뉴 조회
                    if (allMenus.isEmpty()) {
                        System.out.println("아직 추천받은 메뉴가 없습니다.");
                    } else {
                        System.out.println("지금까지 추천받은 메뉴 목록:");
                        for (RecommendMenu menu : allMenus) {
                            System.out.println(menu.getNumNo() + ". " + menu.getMenuName());
                        }
                    }
                    break;
                case 0:
                    System.out.println("추천 메뉴 프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못 선택했습니다.");
            }

            if (menuName != null) {
                int newNo = menuRepository.getNextNo(); // numNo 자동 증가
                RecommendMenu recommendedMenu = new RecommendMenu(newNo, menuName);
                menuRepository.save(recommendedMenu); // 추천 메뉴 저장
                System.out.println("추천 메뉴가 저장되었습니다: " + recommendedMenu.getMenuName() + " (번호: " + recommendedMenu.getNumNo() + ")");
            }

            if (nationChoice != 0) {
                System.out.println("\n다시 추천을 받으시겠습니까? (계속하려면 1, 추천받은 메뉴 조회하려면9, 종료하려면 0)");
                int continueChoice = sc.nextInt();
                sc.nextLine();
                if (continueChoice == 0) {
                    nationChoice = 0;
                    System.out.println("추천 메뉴 프로그램을 종료합니다.");
                }else if (continueChoice == 9) {
                    List<RecommendMenu> allMenus = menuRepository.findAll();
                    if (allMenus.isEmpty()) {
                        System.out.println("아직 추천받은 메뉴가 없습니다.");
                    } else {
                        System.out.println("지금까지 추천받은 메뉴 목록:");
                        for (RecommendMenu menu : allMenus) {
                            System.out.println(menu.getNumNo() + ". " + menu.getMenuName());
                        }
                    }
                }
            }

        } while (nationChoice != 0);

        // sc.close(); // Service 클래스에서는 닫지 않는 게 안전
    }

    //지금까지 저장된 모든 추천 메뉴 조회
    public void findMenu() {
        ArrayList<RecommendMenu> allMenus = new ArrayList<>(menuRepository.findAll());
        if (!allMenus.isEmpty()) {
            System.out.println("=== 전체 추천 메뉴 목록 ===");
            for (RecommendMenu menu : allMenus) {
                System.out.println("번호: " + menu.getNumNo() + ", 메뉴명: " + menu.getMenuName());
            }
        } else {
            System.out.println("추천 메뉴가 없습니다.");
        }
    }
}
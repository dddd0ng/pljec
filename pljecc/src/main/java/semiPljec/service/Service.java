package semiPljec.service;

import semiPljec.repository.Repository;
import semiPljec.user.AccountStatus;
import semiPljec.user.Member;

import java.util.ArrayList;

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
}

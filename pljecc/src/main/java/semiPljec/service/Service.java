package semiPljec.service;

import semiPljec.repository.Repository;
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
        if(repository.isNicknameExists(newMember.getNickname())){
            System.out.println("이미 존재하는 닉네임임니다.");
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
        repository.save(newMember);
        System.out.println("회원가입 성공");
    }
}

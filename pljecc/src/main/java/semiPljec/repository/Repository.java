package semiPljec.repository;

import semiPljec.user.AccountStatus;
import semiPljec.user.Member;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Repository {
    private final ArrayList<Member> memberList = new ArrayList<>();
    private final File file = new File("/Users/dong/pljec/pljecc/src/main/java/semiPljec/db/mariaDB.dat");

    public Repository() {
        if(!file.exists()){
            {
                try {
                    // 파일이 위치할 디렉토리가 없으면 생성합니다.
                    file.getParentFile().mkdirs();
                    // 파일을 새로 생성합니다.
                    file.createNewFile();
                    // 생성된 파일에 초기 데이터를 저장합니다.
//        saveMembers(defaultMemberList);
                } catch (IOException e) {
                    System.out.println("초기 데이터 파일을 생성하거나 저장하는 데 오류가 발생했습니다.");
                    throw new RuntimeException(e);
                }
//        loadMembers();
            }
        }

    }

    public ArrayList<Member> findAllMembers() {
        ArrayList<Member> result = new ArrayList<>();
        for (Member member : result) {
            if (member.getAccountStatus() == AccountStatus.ACTIVE) {
                result.add(member);
            }
        }   return result;
    }



    public boolean isNicknameExists(String nickname) {
        //리스트 순회하면서 닉네임 중복 확인
        if (nickname == null) {
            return false;
        }
        for (Member member : memberList) {
            if (member.getNickname().equals(nickname)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmailExists(String email) {
        //리스트 순회하면서 이메일 중복 확인
        if(email==null){
            return false; // null값은 중복 검사 대상이 아님
        }
        for (Member member : memberList) { // 모든 Member 객체 순회
            //member.getEmail()이 null이 아니고 입력된 이메일과 동일한 경우 중복으로 판단함
            //문자열 비교는 ==이 아니라 .equals() 사용해야함
            if (email.equals(member.getEmail())) {
                return true;
            }
        }
        return false; //중복된 이메일 없음
    }

    public boolean isPhoneExists(String phone) {
        //리스트 순회하면서 전화번호 중복 확인
        if(phone==null){
            return false;
        }
        for (Member member : memberList) {
            //member.getPhone()이 null이 아니고 입력된 이메일과 동일한 경우 중복으로 판단함
            //문자열 비교는 ==이 아니라 .equals() 사용해야함
            if (phone.equals(member.getPhone())) {
                return true;
            }
        }
        return false;
    }

    public void save(Member newMember) {
        //실제 저장
        if(newMember != null) {
            memberList.add(newMember);
        }
    }
}
// Repository = 데이터 저장, 조회, 관리하는 역할 (데이터 영속성)


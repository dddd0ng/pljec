package semiPljec.repository;

import semiPljec.stream.Output;
import semiPljec.user.AccountStatus;
import semiPljec.user.Member;

import java.io.*;
import java.util.ArrayList;

// DB/파일 입출력 담당 (데이터 저장/조회(불러오기))
public class MemberRepository {
    private final ArrayList<Member> memberList = new ArrayList<>();
    private final File file = new File("db/member.dat");

    public MemberRepository() {
        if(!file.exists()){
            ArrayList<Member> defaultMemberList = new ArrayList<>();
            try {
                // 파일이 위치할 디렉토리가 없으면 생성
                file.getParentFile().mkdirs();
                // 파일 새로 생성
                file.createNewFile();
                // 초기 데이터를 저장 (빈 리스트)
                saveMembers(defaultMemberList);
            } catch (IOException e) {
                System.out.println("초기 데이터 파일을 생성하거나 저장하는 데 오류가 발생했습니다.");
                throw new RuntimeException(e);
            }
        }
        loadMembers();
    }

//Output스트림으로 .dat파일에 객체 직렬화 후 저장
    //meberList에 추가 후, saveMembers(memberList)호출
    //반환값:1 -> 성공, 반환값:0 ->실패
    public int registMember(Member newMember) {
        Output moo = null;
        int result = 0;
        try{
            moo=new Output(new BufferedOutputStream(new FileOutputStream(file, true)));
            moo.writeObject(newMember);
            moo.flush();
            //buffered때매 출력할 때 flush() 필요함, 없으면 값 안나옴
            //컬렉션에 담긴 기존 회원을 지우고 다시 파일의 정보를 토대로
            //컬렉션이 회원으로 채워지도록 작성
//            memberList.clear();
//            loadMembers();
            memberList.add(newMember);
            saveMembers(memberList);

            result=1;
        }catch(IOException e){
            throw new RuntimeException(e);
        }finally{
            try{
                if (moo != null) moo.close();
            }catch(IOException e){
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    private void loadMembers() {
        if(file.length() == 0) return; // 파일 비어있으면 그냥 종료

        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            while(true) {
                memberList.add((Member) ois.readObject());
            }
        } catch (EOFException e) {
            System.out.println("회원 정보 읽어오기 완료!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Member> findAllMembers() {
        ArrayList<Member> result = new ArrayList<>();
        for (Member member : memberList) {
            if (member.getAccountStatus() == AccountStatus.ACTIVE) {
                result.add(member);
            }
        }   return result;
    }



    public boolean isIdExists(String id) {
        if(id==null){
            return false;
        }
        for (Member member : memberList) {
            if (member.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPwdExists(String pwd) {
        if (pwd == null){
            return false;}
        return false;
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

    //특정 ID회원 조회 + ACTIVE상태 확인
    public Member findMember(String id) {
        for (Member member : memberList) {
            if (id != null && id.equals(member.getId()) && member.getAccountStatus() == AccountStatus.ACTIVE) {
                return member;
            }
        }
        return null;
    }

    public int modifyMember(Member modifyMember) {
        // repository가 가진 컬렉션의 회원부터 수정
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getId().equals(modifyMember.getId())) {
                memberList.set(i, modifyMember);
                saveMembers(memberList);
                return 1;
            }

        }
        return 0;
    }

    private void saveMembers(ArrayList<Member> members) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            for (Member member : members) {
                oos.writeObject(member);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                if(oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public int removeMember(String memId) {
        int result = 0;
        for (Member member : memberList) {
            if (member.getId().equals(memId)) {
                member.setAccountStatus(AccountStatus.DEACTIVE);

                saveMembers(memberList);

                result = 1;
                break;
            }
        }return result;
    }

    public int findLastMemberNo() {
        if (memberList.isEmpty()) {
            return 0;   // 아직 회원이 없으면 0 리턴
        }
        // 마지막 회원 번호 꺼내오기
        return memberList.get(memberList.size() - 1).getMemNo();
    }


}
// Repository = 데이터 저장, 조회, 관리하는 역할 (데이터 영속성)
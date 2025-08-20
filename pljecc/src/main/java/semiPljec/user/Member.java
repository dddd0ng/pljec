package semiPljec.user;

import java.io.Serializable;
import java.util.List;

public class Member implements Serializable {
    private int memNo;
    private String id;
    private String pwd;
    private String nickname;                // 닉네임 중복방지
    private String email;                   // 이메일 중복방지
    private String phone;                   // 폰번호 중복방지
    private List<String> recommendMenus;    // 추천한 메뉴
    private String voted;                   // 내가 투표한 메뉴 (중복투표 방지)
    private AccountStatus accountStatus; // 회원 상태(소프트탈퇴 활성 비활성)

    //회원가입 시 사용자가 입력한 값을 지닌 Member 객체가 되기 위한 생성자

    public Member(String id, String pwd, String nickname, String email, String phone) {
        this.id = id;
        this.pwd = pwd;
        this.nickname = nickname;
        this.email = email;
        this.phone = phone;
    }

    //기본 생성자

    public Member(){

    }
    public Member(int memNo, String id, String pwd, String nickname, String email, String phone, List<String> recommendMenus, String voted, AccountStatus accountStatus) {
        this.memNo = memNo;
        this.id = id;
        this.pwd = pwd;
        this.nickname = nickname;
        this.email = email;
        this.phone = phone;
        this.recommendMenus = recommendMenus;
        this.voted = voted;
        this.accountStatus = accountStatus;
    }

    public int getMemNo() {
        return memNo;
    }

    public void setMemNo(int memNo) {
        this.memNo = memNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getRecommendMenus() {
        return recommendMenus;
    }

    public void setRecommendMenus(List<String> recommendMenus) {
        this.recommendMenus = recommendMenus;
    }

    public String getVoted() {
        return voted;
    }

    public void setVoted(String voted) {
        this.voted = voted;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memNo=" + memNo +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", recommendMenus=" + recommendMenus +
                ", voted='" + voted + '\'' +
                ", accountStatus=" + accountStatus +
                '}';
    }
}

package semiPljec.menu;

import java.io.Serializable;

public class RecommendMenu implements Serializable {
    private static int sequence = 1;

    private int numNo;              //메뉴 추천 번호
    private String menuName;        //추천된 메뉴 이름
    private String memberId;        //추천한 회원 Id

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }




    public void setNumNo(int numNo) {
        this.numNo = numNo;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getNumNo() {
        return numNo;
    }

    public String getMenuName() {
        return menuName;
    }

    public RecommendMenu(int numNo, String menuName, String memberId) {
        this.numNo = numNo;
        this.menuName = menuName;
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "RecommendMenu{" +
                "numNo=" + numNo +
                ", menuName='" + menuName + '\'' +
                ", memberId='" + memberId + '\'' +
                '}';
    }
}

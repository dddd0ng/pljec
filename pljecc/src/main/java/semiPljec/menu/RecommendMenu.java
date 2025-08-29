package semiPljec.menu;

import java.io.Serializable;

public class RecommendMenu implements Serializable {
    private int numNo;              //메뉴 추천 번호
    private String menuName;        //추천된 메뉴 이름

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

    public RecommendMenu(int numNo, String menuName) {
        this.numNo = numNo;
        this.menuName = menuName;
    }

    @Override
    public String toString() {
        return numNo + ". " + menuName;
    }
}
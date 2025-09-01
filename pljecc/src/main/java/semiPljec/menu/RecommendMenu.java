    package semiPljec.menu;

    import java.io.Serializable;

    //추천된 메뉴 1개를 표현하는 데이터 객체(DTO,엔티티 역할)
    //직렬화 가능, recommendedMenu.dat파일에 저장 가능
    public class RecommendMenu implements Serializable {
        private int numNo;              //메뉴 추천 번호 (자동증가,menuRepository에서 관리)
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
package semiPljec.menu;

import java.util.Random;

public enum WesternMenu {
    // 파스타/리조또
    CARBONARA("까르보나라", "양식", "파스타/리조또"),
    BOLOGNESE("볼로네제", "양식", "파스타/리조또"),
    ALIOOLIO("알리오올리오", "양식", "파스타/리조또"),
    PESTO("페스토", "양식", "파스타/리조또"),
    SEAFOOD_CREAM_PASTA("해물크림파스타", "양식", "파스타/리조또"),
    MUSHROOM_RISOTTO("버섯리조또", "양식", "파스타/리조또"),

    // 피자
    MARGHERITA("마르게리타", "양식", "피자"),
    PEPPERONI("페퍼로니", "양식", "피자"),
    QUATTRO_FORMAGGI("콰트로포르마지", "양식", "피자"),
    HAWAIIAN_PIZZA("하와이안피자", "양식", "피자"),
    SEAFOOD_PIZZA("해물피자", "양식", "피자"),

    // 고기/해산물
    STEAK("스테이크", "양식", "고기/해산물"),
    CHICKEN_STEAK("치킨스테이크", "양식", "고기/해산물"),
    MEATLOAF("미트로프", "양식", "고기/해산물"),
    BBQ_RIBS("바비큐립", "양식", "고기/해산물"),
    GRILLED_SALMON("연어구이", "양식", "고기/해산물"),
    GRILLED_SHRIMP("새우구이", "양식", "고기/해산물"),

    // 샐러드/전채
    CAESAR_SALAD("시저샐러드", "양식", "샐러드/전채"),
    CAPRESE("카프레제", "양식", "샐러드/전채"),
    NICOISE_SALAD("니수아즈샐러드", "양식", "샐러드/전채"),
    BRUSCHETTA("브루스케타", "양식", "샐러드/전채"),

    // 수프
    CREAM_SOUP("크림수프", "양식", "수프"),
    TOMATO_SOUP("토마토수프", "양식", "수프"),
    MINESTRONE("미네스트로네", "양식", "수프"),
    MUSHROOM_SOUP("버섯수프", "양식", "수프"),

    // 간식/디저트
    BROWNIE("브라우니", "양식", "간식/디저트"),
    TIRAMISU("티라미수", "양식", "간식/디저트"),
    CHEESE_CAKE("치즈케이크", "양식", "간식/디저트"),
    POUND_CAKE("파운드케이크", "양식", "간식/디저트"),
    COOKIE("쿠키", "양식", "간식/디저트");

    private final String koreanName; // 한글 이름
    private final String category;
    private final String type;

    WesternMenu(String koreanName, String category, String type) {
        this.koreanName = koreanName;
        this.category = category;
        this.type = type;
    }

    public String getKoreanName() { return koreanName; }
    public String getCategory() { return category; }
    public String getType() { return type; }

    public static WesternMenu getRandomMenu() {
        WesternMenu[] menus = values();
        return menus[new Random().nextInt(menus.length)];
    }
}

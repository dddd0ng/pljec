package semiPljec.user;

import java.util.Random;

public enum ChineseMenu {
    // 면류
    JJAJANGMYEON("짜장면", "중식", "면류"),
    JJAMPPONG("짬뽕", "중식", "면류"),
    BOKKEUMMYEON("볶음면", "중식", "면류"),
    TANTANMEN("탄탄면", "중식", "면류"),
    WANTANMEN("완탕면", "중식", "면류"),

    // 밥류
    BOKKEUMBAP("볶음밥", "중식", "밥류"),
    YUSANSEULBAP("유산슬밥", "중식", "밥류"),
    CRABBAP("게살밥", "중식", "밥류"),
    JABCHAE_BAP("잡채밥", "중식", "밥류"),
    SEAFOOD_BAP("해물밥", "중식", "밥류"),

    // 고기/해물 요리
    TANGSUYUK("탕수육", "중식", "고기/해물"),
    KANPUNGKI("깐풍기", "중식", "고기/해물"),
    YULINGI("유린기", "중식", "고기/해물"),
    PALBOCHAE("팔보채", "중식", "고기/해물"),
    GOCHUJABCHAE("고추잡채", "중식", "고기/해물"),
    MARASHANGGUO("마라샹궈", "중식", "고기/해물"),
    KANSHO_SAEU("깐쇼새우", "중식", "고기/해물"),

    // 채소/두부 요리
    MAPADUBU("마파두부", "중식", "채소/두부"),
    DUBU_DUANJIANG("두부두장", "중식", "채소/두부"),
    EGGPLANT_BOKKEUM("가지볶음", "중식", "채소/두부"),
    CHEONGGYEONGCHAE_BOKKEUM("청경채볶음", "중식", "채소/두부"),

    // 만두/간식류
    GUNMANDU("군만두", "중식", "만두/간식"),
    JINMANDU("찐만두", "중식", "만두/간식"),
    MULMANDU("물만두", "중식", "만두/간식"),
    XIAOLONGBAO("샤오롱바오", "중식", "만두/간식"),
    DIMSUM("딤섬", "중식", "만두/간식"),
    WANTAN("완탕", "중식", "만두/간식");

    private final String koreanName; // 한글 이름
    private final String category;
    private final String type;

    ChineseMenu(String koreanName, String category, String type) {
        this.koreanName = koreanName;
        this.category = category;
        this.type = type;
    }

    public String getKoreanName() { return koreanName; }
    public String getCategory() { return category; }
    public String getType() { return type; }

    public static ChineseMenu getRandomMenu() {
        ChineseMenu[] menus = values();
        return menus[new Random().nextInt(menus.length)];
    }
}

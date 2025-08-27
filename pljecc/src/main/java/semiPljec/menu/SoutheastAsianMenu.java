package semiPljec.menu;

import java.util.Random;

public enum SoutheastAsianMenu {
    // 🇹🇭 태국
    TOM_YUM_KOONG("똠얌꿍", "동남아", "국/탕/찌개"),
    TOM_KHA_GAI("닭코코넛수프", "동남아", "국/탕/찌개"),
    PAD_THAI("팟타이", "동남아", "면류"),
    KAO_PAT("태국식 볶음밥", "동남아", "밥류"),
    THAI_CURRY_RICE("태국식 커리덮밥", "동남아", "밥류"),
    GREEN_CURRY("그린커리", "동남아", "고기/해물"),
    RED_CURRY("레드커리", "동남아", "고기/해물"),
    MASSAMAN_CURRY("마싸만커리", "동남아", "고기/해물"),
    BASIL_CHICKEN("바질치킨", "동남아", "고기/해물"),
    SOMTUM("쏨땀", "동남아", "채소/샐러드"), // 파파야 샐러드
    MANGO_STICKY_RICE("망고 찹쌀밥", "동남아", "간식/디저트"),
    COCONUT_PUDDING("코코넛 푸딩", "동남아", "간식/디저트"),
    BANANA_FRIED("바나나 튀김", "동남아", "간식/디저트"),

    // 🇻🇳 베트남
    PHO("쌀국수", "동남아", "국/탕/찌개"),
    SPICY_SEAFOOD_SOUP("해산물 매운탕", "동남아", "국/탕/찌개"), // 베트남식 응용
    RICE_NOODLE("분(쌀국수)", "동남아", "면류"),
    FRIED_RICE_NOODLE("볶음 쌀국수", "동남아", "면류"),
    CUCUMBER_SALAD("오이 샐러드", "동남아", "채소/샐러드"), // 베트남식

    // 🇮🇩 인도네시아
    MIE_GORENG("미고랭", "동남아", "면류"),
    NASI_GORENG("나시고랭", "동남아", "밥류"),
    FRIED_SHRIMP("새우튀김", "동남아", "고기/해물"), // 인도네시아식

    // 🇲🇾 말레이시아 / 싱가포르
    LAKSA("락사", "동남아", "면류"),
    COCONUT_RICE("코코넛 라이스", "동남아", "밥류"), // 나시 레막

    // 🇵🇭 필리핀
    TAPIOCA_PEARL("사고", "동남아", "간식/디저트"); // 타피오카 펄 디저트

    private final String koreanName; // 한글 이름
    private final String category;
    private final String type;

    SoutheastAsianMenu(String koreanName, String category, String type) {
        this.koreanName = koreanName;
        this.category = category;
        this.type = type;
    }

    public String getKoreanName() { return koreanName; }
    public String getCategory() { return category; }
    public String getType() { return type; }

    public static SoutheastAsianMenu getRandomMenu() {
        SoutheastAsianMenu[] menus = values();
        return menus[new Random().nextInt(menus.length)];
    }
}

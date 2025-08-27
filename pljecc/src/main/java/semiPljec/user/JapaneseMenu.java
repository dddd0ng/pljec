package semiPljec.user;

import java.util.Random;

public enum JapaneseMenu    {
    // 밥/초밥
    SUSHI("스시", "일식", "밥/초밥"),
    CHIRASHI("치라시", "일식", "밥/초밥"),
    GYUDON("규동", "일식", "밥/초밥"),
    KATSUDON("가츠동", "일식", "밥/초밥"),
    TENDON("텐동", "일식", "밥/초밥"),
    ONIGIRI("오니기리", "일식", "밥/초밥"),

    // 면류
    RAMEN("라멘", "일식", "면류"),
    UDON("우동", "일식", "면류"),
    SOBA("소바", "일식", "면류"),
    YAKISOBA("야키소바", "일식", "면류"),
    COLD_SOBA("자루소바", "일식", "면류"),

    // 튀김류
    TEMPURA("덴푸라", "일식", "튀김류"),
    KARAAGE("카라아게", "일식", "튀김류"),
    SHRIMP_TEMPURA("새우튀김", "일식", "튀김류"),
    VEGETABLE_TEMPURA("야채튀김", "일식", "튀김류"),

    // 구이/조림류
    YAKITORI("야키토리", "일식", "구이/조림류"),
    FISH_GRILL("생선구이", "일식", "구이/조림류"),
    UNAGI_DON("장어덮밥", "일식", "구이/조림류"),
    SAKE_GRILL("연어구이", "일식", "구이/조림류"),

    // 국물/찌개류
    MISO_SOUP("미소된장국", "일식", "국물/찌개류"),
    NABE("나베", "일식", "국물/찌개류"),
    ODENG("오뎅", "일식", "국물/찌개류"),
    TSUKEMONO("츠케모노", "일식", "국물/찌개류");

    private final String koreanName; // 한글 이름
    private final String category;
    private final String type;

    JapaneseMenu(String koreanName, String category, String type) {
        this.koreanName = koreanName;
        this.category = category;
        this.type = type;
    }

    public String getKoreanName() { return koreanName; }
    public String getCategory() { return category; }
    public String getType() { return type; }

    public static JapaneseMenu getRandomMenu() {
        JapaneseMenu[] menus = values();
        return menus[new Random().nextInt(menus.length)];
    }
}

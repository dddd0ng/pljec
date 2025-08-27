package semiPljec.user;

import java.util.Random;

public enum KoreanMenu {
    // 국/탕/찌개
    DOENJANGJJIGAE("된장찌개", "한식", "국/탕/찌개"),
    KIMCHIJJIGAE("김치찌개", "한식", "국/탕/찌개"),
    SUNDUBUJJIGAE("순두부찌개", "한식", "국/탕/찌개"),
    BUDAEJJIGAE("부대찌개", "한식", "국/탕/찌개"),
    GAMJATANG("감자탕", "한식", "국/탕/찌개"),
    SEOLLEONGTANG("설렁탕", "한식", "국/탕/찌개"),
    SAMGYETANG("삼계탕", "한식", "국/탕/찌개"),
    GOMTANG("곰탕", "한식", "국/탕/찌개"),
    YUKGAEJANG("육개장", "한식", "국/탕/찌개"),
    GALBITANG("갈비탕", "한식", "국/탕/찌개"),
    CHEONGGUKJANG("청국장", "한식", "국/탕/찌개"),
    CHUEOTANG("추어탕", "한식", "국/탕/찌개"),

    // 밥/죽/면류
    BIBIMBAP("비빔밥", "한식", "밥/죽/면류"),
    DOLSOT_BIBIMBAP("돌솥비빔밥", "한식", "밥/죽/면류"),
    JABCHAE_BAP("잡채밥", "한식", "밥/죽/면류"),
    KONGNABU_BAP("콩나물밥", "한식", "밥/죽/면류"),
    KIMBAP("김밥", "한식", "밥/죽/면류"),
    TTEOKGUK("떡국", "한식", "밥/죽/면류"),
    NAENGMYEON("냉면", "한식", "밥/죽/면류"),
    KALGOOKSU("칼국수", "한식", "밥/죽/면류"),
    JANCHI_GUKSU("잔치국수", "한식", "밥/죽/면류"),
    BIBIM_GUKSU("비빔국수", "한식", "밥/죽/면류"),
    KONGGUKSU("콩국수", "한식", "밥/죽/면류"),
    GUKSU("국수", "한식", "밥/죽/면류"),

    // 구이/볶음류
    BULGOGI("불고기", "한식", "구이/볶음류"),
    GALBIJJIM("갈비찜", "한식", "구이/볶음류"),
    JEYUK_BOKKEUM("제육볶음", "한식", "구이/볶음류"),
    DAKGALBI("닭갈비", "한식", "구이/볶음류"),
    OJINGEO_BOKKEUM("오징어볶음", "한식", "구이/볶음류"),
    GALCHIJORIM("갈치조림", "한식", "구이/볶음류"),
    SAMGYEOPSAL("삼겹살", "한식", "구이/볶음류"),
    YANGNYUMCHICKEN("양념치킨", "한식", "구이/볶음류"),
    DAKGANGJEONG("닭강정", "한식", "구이/볶음류"),

    // 전/부침류
    PAJEON("파전", "한식", "전/부침류"),
    KIMCHIJEON("김치전", "한식", "전/부침류"),
    HAEMULPAJEON("해물파전", "한식", "전/부침류"),
    NOKDUJEON("녹두전", "한식", "전/부침류"),
    DONGGRANGTTAENG("동그랑땡", "한식", "전/부침류"),
    GAMJAJEON("감자전", "한식", "전/부침류"),
    HOBAGJEON("호박전", "한식", "전/부침류"),
    KKAENNIPJEON("깻잎전", "한식", "전/부침류"),

    // 반찬/나물류
    SIGUMCHI_NAMUL("시금치나물", "한식", "반찬/나물류"),
    DORAJI_NAMUL("도라지나물", "한식", "반찬/나물류"),
    KONGNAMUL_MUCHIM("콩나물무침", "한식", "반찬/나물류"),
    OI_MUCHIM("오이무침", "한식", "반찬/나물류"),
    MUSAENGCHAE("무생채", "한식", "반찬/나물류"),
    MYEOLCHI_BOKKEUM("멸치볶음", "한식", "반찬/나물류"),
    JANGJORIM("장조림", "한식", "반찬/나물류"),
    GYEOT_BOKKEUM("견볶음", "한식", "반찬/나물류"),
    KIMJABAN("김자반", "한식", "반찬/나물류"),

    // 간식/떡류
    TTEOKBOKKI("떡볶이", "한식", "간식/떡류"),
    SUNDAE("순대", "한식", "간식/떡류"),
    MANDU("만두", "한식", "간식/떡류"),
    HOTTEOK("호떡", "한식", "간식/떡류"),
    YAKGWA("약과", "한식", "간식/떡류"),
    SONGPYEON("송편", "한식", "간식/떡류"),
    INJEOLMI("인절미", "한식", "간식/떡류"),
    GYEONGDAN("경단", "한식", "간식/떡류");

    private final String koreanName; // 한글 이름
    private final String category;
    private final String type;

    KoreanMenu(String koreanName, String category, String type) {
        this.koreanName = koreanName;
        this.category = category;
        this.type = type;
    }

    public String getKoreanName() { return koreanName; }
    public String getCategory() { return category; }
    public String getType() { return type; }

    public static KoreanMenu getRandomMenu() {
        KoreanMenu[] menus = values();
        return menus[new java.util.Random().nextInt(menus.length)];
    }
}

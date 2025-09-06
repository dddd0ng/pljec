package semiPljec.repository;

import semiPljec.menu.RecommendMenu;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private static final String FILE_NAME = "db/recommendedMenu.dat";
    private List<RecommendMenu> menuList = new ArrayList<>();
    private int lastNo = 0; // 자동 증가 번호

    //프로그램 시작 시 recommendedMenu.dat파일 읽어와 menuList초기화
    //마지막 번호 lastNo도 불러옴
    public MenuRepository() {
        load(); // 시작할 때 파일 불러오기
    }

    //추천메뉴를 menuList에 추가
    //saveToFile()호출 -> 파일에 직렬화 저장
    public void save(RecommendMenu menu) {
        menuList.add(menu);
        saveToFile();
    }

    //지금까지 저장된 모든 추천 메뉴 반환(조회기능)
    public List<RecommendMenu> findAll() {
        return menuList;
    }

    //자동 증가 번호 관리 LastNo 증가시키고 반환
    //메뉴 고유 번호numNo 생성용
    public int getNextNo() {
        return ++lastNo;
    }

    // 파일 저장
    //ObjectOutputStream으로 menuList전체 직렬화->recommendMenu.dat
    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(menuList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 파일 불러오기
    // 파일이 존재하면 menuList불러오기, 마지막 메뉴번호 lastNo갱신
    private void load() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            menuList = (List<RecommendMenu>) ois.readObject();
            if (!menuList.isEmpty()) {
                lastNo = menuList.get(menuList.size() - 1).getNumNo();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveAll(List<RecommendMenu> menus) {
        this.menuList = menus;
        saveToFile(); // 기존 saveToFile() 사용
    }
}
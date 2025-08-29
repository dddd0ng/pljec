package semiPljec.repository;

import semiPljec.menu.RecommendMenu;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private static final String FILE_NAME = "db/recommendedMenu.dat";
    private List<RecommendMenu> menuList = new ArrayList<>();
    private int lastNo = 0; // 자동 증가 번호

    public MenuRepository() {
        load(); // 시작할 때 파일 불러오기
    }

    public void save(RecommendMenu menu) {
        menuList.add(menu);
        saveToFile();
    }

    public List<RecommendMenu> findAll() {
        return menuList;
    }

    public int getNextNo() {
        return ++lastNo;
    }

    // 파일 저장
    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(menuList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 파일 불러오기
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
}
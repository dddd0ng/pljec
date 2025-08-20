package semiPljec.app;

import semiPljec.service.Service;
import semiPljec.user.Member;
import java.util.Scanner;

public class Application {
    private static final Service service = new Service();
    public static void main(String[] args) {


    Scanner sc = new Scanner(System.in);
    while(true){
        System.out.println("=======회원 관리 시스템=======");
        System.out.println("1. 모든 회원 정보 보기");
        System.out.println("2. 회원 찾기");
        System.out.println("3. 회원 가입");
        System.out.println("4. 회원 정보 수정");
        System.out.println("5. 추천 메뉴 조회");
        System.out.println("6. 추천 메뉴 삭제");
        System.out.println("7. 회원 탈퇴");
        System.out.println("9. 프로그램 종료");
        System.out.print("메뉴를 선택해주세요 : ");
        int input = sc.nextInt();

        switch(input){
            case 1: // 모든 회원 정보 보기
                service.fineAllMembers();
                break;
            case 2: // 회원 찾기
//                service.
                break;
            case 3: // 회원 가입
                service.registMember(signup());
                break;
            case 4: // 회원 정보 수정
//                service.
                break;
            case 5: // 추천 메뉴 조회
//                service.
                break;
            case 6: // 추천 메뉴 삭제
//                service.
                break;
            case 7: // 회원 탈퇴
//                service.
                break;
                case 9: // 프로그램 종료
                    System.out.println("프로그램을 종료하겠습니다.");
                    return;
            default:
                System.out.println("번호를 잘못 입력하셨습니다.");;
        }


    }

    }

    //case 3: 회원가입
    private static Member signup() {
      Member member = null;
      Scanner sc = new Scanner(System.in);

      System.out.println("아이디를 입력하세요 : ");
      String id = sc.nextLine();

      System.out.println("패스워드를 입력하세요 : ");
      String password = sc.nextLine();

      System.out.println("닉네임을 입력하세요 : ");
      String Nickname = sc.nextLine();

      System.out.println("이메일을 입력하세요 : ");
      String Email = sc.nextLine();

      System.out.println("전화번호를 입력하세요 : ");
      String Phone = sc.nextLine();


        member = new Member(id, password, Nickname, Email, Phone);
        return member;
    }

}



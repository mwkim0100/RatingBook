package System;

import java.util.ArrayList;
import java.util.Scanner;


class Book{
    String title;
    int score;
    static int count;

    public Book(String title,Integer score){
        this.title=title;
        this.score=score;
        count++;//list에 등록된 책의 권 수
    }

}

public class Machine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Book> list = new ArrayList<Book>();


        do {
            System.out.println("==========================");
            System.out.println("1. 책 등록");
            System.out.println("2. 책 검색");
            System.out.println("3. 모든 책 출력");
            System.out.println("4. 종료");
            System.out.println("==========================");
            System.out.print("번호를 입력하시오: ");
            int select = scanner.nextInt();

            if (select == 1) {
                System.out.print("등록하려는 책의 제목: ");
                String registerbook = scanner.next(); //책 제목 입력
                System.out.print("평점: "); //책 평점 입력
                Integer ratingbook = scanner.nextInt();
                list.add(new Book(registerbook, ratingbook));//list의 0번째에 저장된 Book의 객체

            }

            //등록 된 책이 없는데 책의 평점을 검색하는 경우
            if (select == 2 && Book.count == 0) {//등록된 책이 없으면 count=0;
                System.out.println("등록된 책이 없습니다.");
                break;
            }
            //책이 등록 되어 있을때 책의 평점을 검색하는 경우
            if (select == 2 && Book.count != 0) {
                System.out.print("검색하려는 책의 제목: ");
                String searchbook = scanner.next();//검색할 책 이름
                int cnt=0;
                for(int i=0;i< list.size();i++){
                    if(list.get(i).title.equals(searchbook)) {
                        cnt++;
                        System.out.println(searchbook + "의 평점은" + list.get(i).score + " 점 입니다.");
                        if(cnt<1){
                            System.out.println(searchbook+"은 등록된 책이 아닙니다.");
                        }
                    }
                }

                }
            //전체 책 출력
            if(select==3 && Book.count!=0){
                for(int i=0;i< list.size();i++){
                    System.out.println("책 제목 : "+list.get(i).title+"평점 : "+list.get(i).score);
                }

            }
            if(select==3 && Book.count==0){
                System.out.println("등록된 책이 없습니다.");
            }
            if(select==4){
                break;
            }
        } while (true);

    }
}














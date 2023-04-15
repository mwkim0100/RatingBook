package System;

import java.util.ArrayList;
import java.util.Scanner;

//개발 목적 : 읽은 책과 평점을 저장하고 저장 되어 있는 책들의 평점과 목록을 찾아 보기
//과정
//1.등록된 책이 없는데 책의 평점을 검색하는 경우 그리고 2.등록된 책은 있지만 검색한 책이 등록된 책이 아닌 경우
//둘 다 list에 존재하지 않는다는 공통점이 있다.그래서 list에 검색한 책 제목이 있는지 확인하고
//없으면 예외를 발생시켜서 다시 검색 하도록 프로그램을 만들려고 했다.
//하지만 등록된 책이 한권도 없는데 검색을 하면 비효율 적이니까
//list에 책이 한권 이상인지를 먼저 확인하고 한 권 이상이라도 책이 등록되어 있으면 검색 아니면
//예외를 발생시키도록 했다.
class EmptyList extends Exception {
    public EmptyList(String a) {
        super(a);
    }
}
class WorngSearchbook extends Exception {
    public WorngSearchbook(String a) {
        super(a);
    }
}


class Book{
    String title;
    int score;
    static int count;

    public Book(String title,Integer score){
        this.title=title;
        this.score=score;
        count++;
    }
}


public class Machine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Book> list = new ArrayList<Book>();


        try {
            System.out.println("==========================");
            System.out.println("1. 책 등록");
            System.out.println("2. 책 검색");
            System.out.println("3. 모든 책 출력");
            System.out.println("4. 종료");
            System.out.println("==========================");
            System.out.println("번호를 입력하시오: ");
            int select = scanner.nextInt();

            if(select==1) {
                System.out.print("제목: ");
                String registerbook=scanner.next(); //책 제목 입력
                System.out.print("평점: "); //책 평점 입력
                Integer ratingbook=scanner.nextInt();
                list.add(new Book(registerbook,ratingbook));//list의 0번째에 저장된 Book의 객체

            }



            //등록 된 책이 없는데 책의 평점을 검색하는 경우
            if(select==2 && Book.count==0) {//등록된 책이 없으면 count=0;
                throw new EmptyList("등록된 책이 없습니다, 먼저 책을 등록하십시오.");
            }
            //책이 등록 되어 있을때 책의 평점을 검색하는 경우
            if(select==2 && Book.count!=0) {
                System.out.println("제목: ");
                String searchbook = scanner.next();//검색할 책 이름
                int num =0;
                for(int i=0;i<Book.count;i++) {
                    if (list.get(i).title.equals(searchbook)) {
                        System.out.println("평점 : " + list.get(i).title);
                    } else {
                        num++;
                        if(Book.count==num){
                            throw new WorngSearchbook(searchbook +"은(는) 등록되지 않은 도서입니다.");

                        }
                    }
                    //list.get(0).title 부터 list.get(count).title 까지 각각 searchbook과
                    //하나하나 대조해 보고 값이 다를때마다 숫자가 하나씩 커진다 만약 그 숫자가 count와 같다면
                    //list에 searchbook에 해당하는 책이 등록이 안되어있다는 뜻이니까
                    //예외를 발생시킨다.

                }
            }
            //ArrayIndexOutOfBoundsException()는
            // 1.등록된 책이 없는데 책의 평점을 검색하는 경우
            // 2.등록된 책은 있지만 검색한 책이 등록된 책이 아닌 경우
            //두 경우에서 발생하는 예외를 포괄하기 때문에
            //타인이 이 코드를 봤을때 모호하독 느낄수 있어서 사용자 정의 예외를 만들기로 했다.
        } catch(EmptyList e) {
            System.out.println(e.getMessage());
        } catch(WorngSearchbook e){
            System.out.println(e.getMessage());
        }

    }


}














package System;

import java.util.ArrayList;
import java.util.Scanner;

/*개발 목적 : 읽은 책과 평점을 저장하고 저장 되어 있는 책들의 평점과 목록을 찾아 보기
과정

1.등록된 책이 없는데 책의 평점을 검색하는 경우 그리고 2.등록된 책은 있지만 검색한 책이 등록된 책이 아닌 경우
둘 다 list에 존재하지 않는다는 공통점이 있다.그래서 list에 검색한 책 제목이 있는지 확인하고
없으면 예외를 발생시켜서 다시 검색 하도록 프로그램을 만들려고 했다.
하지만 등록된 책이 한권도 없는데 검색을 하면 비효율 적이니까
list에 책이 한권 이상인지를 먼저 확인하고 한 권 이상이라도 책이 등록되어 있으면 검색 아니면
예외를 발생시키도록 했다.


프로그램을 실행 시키고 1번을 입력했더니 책 1권을 등록한후 프로그램이 끝나버렸다.
do while 반복문을 사용하면 사용자가 프로그램 종료를 원하기 전까지 프로그램이 종료되지 않는다.


코드의 간결함을 위해 책 등록,책 검색,모든 책 출력 메서드를 따로 만들겠다.


책들을 저장하는 ArrayList를 main 메서드에 만들었는데 메서드내에서 ArrayList에 책 객체를
추가한다거나 검색하는 동작을 구현하려면 ArrayList객체를 생성해야한다
메서드를 호출할때마다 ArrayList객체를 생성하면 전에 저장했던 데이터를 못쓰니까 메서드는 만들지 말아야 겠다.
*/



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














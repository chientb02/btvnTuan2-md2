package btvn.bt1;

import java.util.ArrayList;

public class ManagerList extends Book {
    ArrayList<Book> listBook = new ArrayList<>();
    public void showBook () {
        listBook.add(new ProgrammingBook(1,"Java",10000,"Vũ ", "English","Sách lập trình"));
        listBook.add(new ProgrammingBook(2,"Js",12000,"Đức", "English","Sách lập trình"));
        listBook.add(new ProgrammingBook(3,"Python",14000,"Vũ Chiến", "English","Sách lập trình"));
        listBook.add(new ProgrammingBook(4,"Ruby",10000,"Đức Chiến", "English","Sách lập trình"));
        listBook.add(new ProgrammingBook(5,"PhP",16000," Chiến", "English","Sách lập trình"));
        listBook.add(new FictionBook(1,"Java1",10000,"Vũ ", "English"));
        listBook.add(new FictionBook(2,"Js1",12000,"Đức", "Viễn tưởng 1"));
        listBook.add(new FictionBook(3,"Python1",14000,"Vũ Chiến", "Viễn tưởng 1"));
        listBook.add(new FictionBook(4,"Ruby1",10000,"Đức Chiến", "Viễn tưởng 1"));
        listBook.add(new FictionBook(5,"PhP1",16000," Chiến", "English"));
    }
    public void total ( ) {
        showBook();
        double total = 0 ;
        for (int i = 0; i < listBook.size(); i++) {
            total += listBook.get(i).getPrice() ;
        }
        System.out.println(total);
    }

    public void countFictionBook () {
        int count = 0 ;
        for (int i = 0; i < listBook.size(); i++) {
            if (listBook.get(i) instanceof FictionBook){
                if (((FictionBook) listBook.get(i)).getCategory() == "Viễn tưởng 1"){
                    count ++ ;
                }
            }
        }
        System.out.println(" có" + count + " quyển sách có category Viễn tưởng 1");
}
    public void countBook () {
        int count= 0 ;
        for (int i = 0; i < listBook.size(); i++) {
            if(listBook.get(i).getPrice() < 90000){
                count ++ ;
            }
        }
        System.out.println("số sách có giá nhỏ hơn 90000 là : " + count );
    }

}

package Programming_with_classes;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookLibrary {
    int count;
    Book[] books;

    public void createLbrary(){
        count=5;
        books=new Book[count];
        books[0]=new Book(1,"leha","OaO knigbild","Opekun, Gazmanov",1924,204,14.99,"paper");
        books[1]=new Book(2,"lepeha","EPAM","Opekun, Gorbunov",1911,4,0.99,"Toilet paper");
        books[2]=new Book(3,"kartoha","gnigoved","Puskin",1901,857,85.99,"Leather");
        books[3]=new Book(4,"kivbasa","EPAM","Opekun",1944,1234,12.99,"Zinc");
        books[4]=new Book(5,"troya","biglove","Gorbunov,Gazmanov",2000,123123,45.99,"wood");
        for (int i=0;i<books.length;i++) {
            System.out.println(books[i]);
            chooseMetod();
        }

        }

    public void chooseMetod() {
        System.out.println("choose a method of :1-author,2-publishing,3-after a given year");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1 -> conclusionByAuthor();
            case 2 -> conclusionByPublishing();
            case 3 -> afterAGivenYear();
        }
    }
public void afterAGivenYear(){
    Scanner scanner=new Scanner(System.in);
    int year=scanner.nextInt();
    for (int i=0;i<books.length;i++){
        if (books[i].getYear()>=year){
            System.out.println(books[i]);
        }
    }

}
    public void conclusionByAuthor(){
        System.out.println("pls enter autor");
        Scanner scanner=new Scanner(System.in);
        Pattern pattern=Pattern.compile(scanner.next());
        for (int i=0;i<books.length;i++){
            Matcher matcher= pattern.matcher(books[i].getAutor());
        if (matcher.find()){
            System.out.println(books[i]);
        }
        }
            }
            public void conclusionByPublishing(){
                System.out.println("pls enter Publishing");
                Scanner scanner=new Scanner(System.in);
                Pattern pattern=Pattern.compile(scanner.next());
                for (int i=0;i<books.length;i++){
                    Matcher matcher= pattern.matcher(books[i].getPublishing());
                    if (matcher.find()){
                        System.out.println(books[i]);
                    }
                }
            }
}
//9. Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
//метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
//методами. Задать критерии выбора данных и вывести эти данные на консоль.
//Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
//Найти и вывести:
//a) список книг заданного автора;
//b) список книг, выпущенных заданным издательством;
//c) список книг, выпущенных после заданного года.
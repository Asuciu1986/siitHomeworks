package oop.library;

import java.util.Arrays;
import java.util.Objects;


/*
This class aggregates the books and performs operations to to the array of books
*/
public class BookLibrary {

    private Book[] books = new Book[20];

    public void addBook(Book book){
        for(int i=0;i<books.length;i++){
            if(Objects.isNull(books[i])){
                books[i]=book;
                break;
            }
        }
    }

    public Book findBookByName(String bookName){
        for(Book book:books){
            if(!Objects.isNull(book)&& book.getName().equals(bookName)) {
                return book;
            }
        }
        return null;
    }

    public boolean deleteBookByName(String bookName){
        for(int i=0;i<books.length;i++){
            if(Objects.isNull(books[i])){
                continue;
            }
            if(books[i].getName().equals(bookName)){
                while(i<books.length-1){
                    books[i]=books[i+1];
                    ++i;
                }
                return true;
            }
        }
        return false;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public void printAllBooks() {
        for(Book book:books){
            if(!Objects.isNull(book)){
                System.out.println(book.toString());
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookLibrary that = (BookLibrary) o;
        return Arrays.equals(books, that.books);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(books);
    }
}



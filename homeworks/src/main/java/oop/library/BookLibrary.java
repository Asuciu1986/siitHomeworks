package oop.library;

import java.util.Arrays;
import java.util.Objects;

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

    public void deleteBook(String bookName){
        for(int i=0;i<books.length;i++){
            if(Objects.isNull(books[i])){
                continue;
            }
            if(books[i].getName().equals(bookName)){
                while(i<books.length-1){
                    books[i]=books[i+1];
                    ++i;
                }
                break;
            }
        }
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "BookLibrary{" +
                "books=" + Arrays.toString(books) +
                '}';
    }
}



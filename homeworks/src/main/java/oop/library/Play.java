package oop.library;

public class Play {

    public static void main(String[] args) {

        BookLibrary bookLibrary = new BookLibrary();
        bookLibrary.addBook(new Novel("War and peace",800,"History"));
        bookLibrary.addBook(new ArtAlbum("Louvre", 700, "premium" ));
        bookLibrary.addBook(new Novel("Game of thrones1",10000,"Fantasy"));
        bookLibrary.addBook(new ArtAlbum("Van Gogh", 600, "premium" ));
        bookLibrary.addBook(new Novel("Game of thrones2",8000,"Fantasy"));
        bookLibrary.addBook(new ArtAlbum("MoMa Collection", 700, "medium" ));
        bookLibrary.addBook(new Novel("Game of thrones3",7000,"Fantasy"));


        bookLibrary.deleteBook("Game of thrones2");

        for(Book book:bookLibrary.getBooks()){
            System.out.println(book);
        }

        System.out.println(bookLibrary.toString());


    }
}

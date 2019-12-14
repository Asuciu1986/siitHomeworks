package oop.library;

import java.util.Objects;

/*
This class contains the main method to check the implementation of of the book library
 */
public class Play {

    public static void main(String[] args) {

        BookLibrary bookLibrary = new BookLibrary();
        bookLibrary.addBook(new Novel("War and peace",800,NovelType.HISTORY));
        bookLibrary.addBook(new ArtAlbum("Louvre", 700, PaperQuality.COATED));
        bookLibrary.addBook(new Novel("Game of thrones1",10000,NovelType.FANTASY));
        bookLibrary.addBook(new ArtAlbum("Van Gogh", 600, PaperQuality.UNCOATED ));
        bookLibrary.addBook(new Novel("Game of thrones2",8000,NovelType.FANTASY));
        bookLibrary.addBook(new ArtAlbum("MoMa Collection", 700, PaperQuality.COATED));
        bookLibrary.addBook(new Novel("Game of thrones3",7000,NovelType.FANTASY));


        Novel novel1 = new Novel();
        novel1.setName("Lolita");
        novel1.setNumberOfPages(367);
        novel1.setType(NovelType.PSYCHOLOGICAL);

        bookLibrary.addBook(novel1);
        System.out.println(bookLibrary.findBookByName("Game of thrones3"));
        boolean deleted = bookLibrary.deleteBookByName("Game of thrones2");
        System.out.println(deleted);
        bookLibrary.printAllBooks();
    }
}

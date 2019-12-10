package oop.library;

public class ArtAlbum extends Book {

    String paperQuality;

    public ArtAlbum(String name, int numberOfPages, String paperQuality) {
        super(name, numberOfPages);
        this.paperQuality = paperQuality;
    }

}

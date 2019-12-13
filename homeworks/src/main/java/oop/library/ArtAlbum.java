package oop.library;

import java.util.Objects;

/*
This class extends book and adds paper quality as attribute
 */
public class ArtAlbum extends Book {

    private PaperQuality paperQuality;

    public ArtAlbum(String name, int numberOfPages, PaperQuality paperQuality) {
        super(name, numberOfPages);
        this.paperQuality = paperQuality;
    }

    public PaperQuality getPaperQuality() {
        return paperQuality;
    }

    public void setPaperQuality(PaperQuality paperQuality) {
        this.paperQuality = paperQuality;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "ArtAlbum{" +
                "paperQuality=" + paperQuality +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtAlbum artAlbum = (ArtAlbum) o;
        return paperQuality == artAlbum.paperQuality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paperQuality);
    }
}

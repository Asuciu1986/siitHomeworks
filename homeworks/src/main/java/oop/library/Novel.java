package oop.library;

import java.util.Objects;

/*
This class extends book and adds novel type as attribute
 */
public class Novel extends Book{

    private NovelType type;

    public Novel() {
    }

    public Novel(String name, int numberOfPages, NovelType type) {
        super(name,numberOfPages);
        this.type = type;
    }

    public NovelType getType() {
        return type;
    }

    public void setType(NovelType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "Novel{" +
                "type=" + type +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Novel novel = (Novel) o;
        return type == novel.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }
}

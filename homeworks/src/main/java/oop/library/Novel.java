package oop.library;

public class Novel extends Book{

    String type;

    public Novel(String name, int numberOfPages,String type) {
        super(name,numberOfPages);
        this.type = type;
    }

}

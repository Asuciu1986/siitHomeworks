package utils.exceptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestExceptionPropagation2 {
    void m() throws IOException {
        throw new IOException("adasda");
    }
    void n() throws IOException {
        m();
    }
    void p(){
       try {
           n();
       }
       catch (IOException e){
           System.out.println("error");
       }
    }
    public static void main(String args[]){

        final List<String> list = new ArrayList<>();
        list.add("ciocan");

        final StringBuilder ss = new StringBuilder("adasdas");
        ss.append("das");
        System.out.println(ss);

        TestExceptionPropagation2 obj=new TestExceptionPropagation2();
        obj.p();
        System.out.println("normal flow");
    }
}

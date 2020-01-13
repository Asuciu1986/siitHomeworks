package oop2;

import javax.net.ssl.SSLContext;
import java.sql.Time;
import java.util.*;

public interface Phone {


    Set<Contact> contacts = new HashSet<>();
    Map<String,List<String>> texts = new HashMap<>();
    List<String> calls = new ArrayList<>();


    default void addContact(String index, String phoneNumber, String firstName, String lastName){
        Contact contact = new Contact(index,phoneNumber,firstName,lastName);
        contacts.add(contact);
    }

    default void listContacts(){
        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }

    default void sendText(String phoneNumber, String message){
        if(message.length()>100){
            System.out.println("The message should have maximum 100 characters");
        }

        else{
            if(!texts.containsKey(phoneNumber)){
                texts.put(phoneNumber,new ArrayList<>());
            }
            texts.get(phoneNumber).add(message);
            System.out.println("Message sent to " + phoneNumber);
        }
    };

    default List<String> listMessages(String phoneNumber){
        if(texts.containsKey(phoneNumber)){
            return texts.get(phoneNumber);
        }
        else{
           return null;
        }

    };

    default void placeCall(String phoneNumber){
        calls.add(phoneNumber);


    };

    default List<String> listCalls(){
        return calls;
    };


}

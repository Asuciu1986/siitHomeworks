package oop2;

import java.util.*;

public interface Phone {

    Set<Contact> contacts = new LinkedHashSet<>();
    Map<String,List<String>> texts = new HashMap<>();
    List<String> calls = new ArrayList<>();


    default void addContact(Integer index, String phoneNumber, String firstName, String lastName){
        Contact contact = new Contact(index,phoneNumber,firstName,lastName);
        contacts.add(contact);
    }

    default void listContacts(){
        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }

    void sendText(String phoneNumber, String message);

    default List<String> listMessages(String phoneNumber){
        return texts.getOrDefault(phoneNumber, null);

    };

    void placeCall(String phoneNumber);

    int getPhoneBatteryLife();

    default List<String> listCalls(){
        return calls;
    };


}

package oop2.phoneapp;

import java.util.*;

public interface Phone {

    void addContact(Integer index, String phoneNumber, String firstName, String lastName);

    void listContacts();

    void sendText(String phoneNumber, String message);

    void listMessages(String phoneNumber);

    void placeCall(String phoneNumber);

    int getCurrentBatteryLife();

    List<String> listCalls();

}

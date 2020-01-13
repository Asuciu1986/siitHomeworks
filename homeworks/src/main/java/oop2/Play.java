package oop2;

import java.util.List;

public class Play {

    public static void main(String[] args) {

        Phone phone = new SamsungGalaxyS6(Color.BLACK,Material.ALUMINUM, "56938035643809");
        phone.addContact(1,"0723518547", "Adrian", "Ene");
        phone.addContact(2,"0745549547", "Nick", "Spalatelu");
        phone.addContact(3,"0745014345", "Ioana", "Apostolu");

        phone.listContacts();

        phone.sendText("0723518547","Ana are mere si pere asdsad sad asdas das dasdasd asdas das as dasd as das das das dsad as das dasd as das das");
        phone.sendText("0723518547","Tema OOP2 este grea");
        List<String> messages = phone.listMessages("0723518547");

        phone.placeCall("0745014345");
        phone.placeCall("0723518547");
        phone.placeCall("0745014345");



        for (String message:messages) {
            System.out.println(message);
        }

        List<String> calls=phone.listCalls();

        for(String call:calls){
            System.out.println(call);
        }

        System.out.println("Battery left:" + phone.getPhoneBatteryLife());
    }
}

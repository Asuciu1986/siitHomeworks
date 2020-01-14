package oop2.phoneapp;

import java.util.List;

public class Play {

    public static void main(String[] args) {

        Phone phone1 = new SamsungGalaxyS6(Color.BLACK,Material.ALUMINUM, "56938035643809");
        Phone phone2 = new AppleIphone11Pro(Color.GREY,Material.ALUMINUM, "57938213123809");

        phone1.addContact(1,"0723518547", "Adrian", "Ene");
        phone1.addContact(2,"0745549547", "Nick", "Spalatelu");
        phone1.addContact(3,"0745014345", "Ioana", "Apostolu");

        phone2.addContact(1,"0745185471", "Chester", "Bennington");

        phone1.listContacts();
        phone2.listContacts();

        phone1.sendText("0723518547","Ana are mere si pere asdsad sad asdas das dasdasd asdas das as dasd as das das das dsad as das dasd as das das");
        phone1.sendText("0723518547","Tema OOP2");

        phone2.sendText("0745185471","One step close");
        phone2.sendText("0745185471","Tema OOP2 nu este asa grea");


        phone1.listMessages("0723518547");
        phone1.listMessages("0748185471");

        phone1.placeCall("0745014345");
        phone1.placeCall("0723518547");
        phone1.placeCall("0745014345");

        phone2.placeCall("0723518547");

        List<String> calls=phone1.listCalls();

        for(String call:calls){
            System.out.println(call);
        }

        System.out.println("Battery left:" + phone1.getCurrentBatteryLife());
    }
}

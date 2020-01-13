package oop2;

import java.util.ArrayList;

public class SamsungGalaxyS6 extends Samsung {

    private static final int batteryLife = 20;
    public int phoneBatteryLife;

    public final String imei;

    public SamsungGalaxyS6(Color color, Material material,String imei) {
        super(color, material);
        this.phoneBatteryLife = batteryLife;
        this.imei = imei;
    }

    public void sendText(String phoneNumber, String message){
        if(message.length()>100){
            System.out.println("The message should have maximum 100 characters. Message was not sent");
        }

        else{
            if(!texts.containsKey(phoneNumber)){
                texts.put(phoneNumber,new ArrayList<>());
            }
            texts.get(phoneNumber).add(message);
            System.out.println("Message sent to " + phoneNumber);
            phoneBatteryLife-=1;
        }
    };

    public void placeCall(String phoneNumber){
        calls.add(phoneNumber);
        phoneBatteryLife-=2;
    };

    public int getPhoneBatteryLife() {
        return phoneBatteryLife;
    }

    @Override
    public String toString() {
        return "SamsungGalaxyS6{" +
                "phoneBatteryLife=" + phoneBatteryLife +
                ", imei='" + imei + '\'' +
                "} " + super.toString();
    }


}

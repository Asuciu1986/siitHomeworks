package oop2.phoneapp;

import java.util.ArrayList;
import java.util.Objects;

public class SamsungGalaxyS6 extends Samsung {

    private static final int batteryLife = 20;
    private int currentBatteryLife;
    private final String imei;

    SamsungGalaxyS6(Color color, Material material, String imei) {
        super(color, material);
        this.currentBatteryLife = batteryLife;
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
            //System.out.println("Message sent to " + phoneNumber);
            currentBatteryLife--;
        }
    };

    public void placeCall(String phoneNumber){
        calls.add(phoneNumber);
        currentBatteryLife -=2;
    };

    public int getCurrentBatteryLife() {
        return currentBatteryLife;
    }

    @Override
    public String toString() {
        return "SamsungGalaxyS6{" +
                "currentBatteryLife=" + currentBatteryLife +
                ", imei='" + imei + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SamsungGalaxyS6 that = (SamsungGalaxyS6) o;
        return currentBatteryLife == that.currentBatteryLife &&
                Objects.equals(imei, that.imei);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentBatteryLife, imei);
    }
}

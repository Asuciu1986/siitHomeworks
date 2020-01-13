package oop2;

public class SamsungGalaxyS6 extends Samsung {

    private static final int batteryLife = 20;
    private int phoneBatteryLife;

    private String imei;


    public SamsungGalaxyS6(String imei, Color color, Material material) {
        this.phoneBatteryLife = batteryLife;
        this.imei = imei;

    }
}

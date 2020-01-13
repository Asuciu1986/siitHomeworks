package oop2;

public class AppleIphone11 extends Apple {

    private static final int batteryLife = 20;
    private int phoneBatteryLife;

    private String imei;

    public AppleIphone11(Color color, Material material,String imei) {
        super(color, material);
        this.phoneBatteryLife = batteryLife;
        this.imei = imei;
    }
}

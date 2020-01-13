package oop2;

public class SamsungGalaxyS6 extends Samsung {

    private static final int batteryLife = 20;
    private int phoneBatteryLife;

    private String imei;

    public SamsungGalaxyS6(Color color, Material material,String imei) {
        super(color, material);
        this.phoneBatteryLife = batteryLife;
        this.imei = imei;
    }

    @Override
    public String toString() {
        return "SamsungGalaxyS6{" +
                "phoneBatteryLife=" + phoneBatteryLife +
                ", imei='" + imei + '\'' +
                "} " + super.toString();
    }
}

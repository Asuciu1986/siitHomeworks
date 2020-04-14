package quiz.logistics2;

import lombok.Setter;

@Setter
public class DeliveryThread implements Runnable {

    private PackageGroup packageGroup;

    public DeliveryThread(PackageGroup packageGroup) {
        this.packageGroup = packageGroup;
    }

    @Override
    public void run() {
        packageGroup.calculateGroupRevenueAndValue();
//        System.out.println(packageGroup.getGroupRevenue());
//        System.out.println(packageGroup.getGroupValue());
        System.out.println("Delivering for " + packageGroup.getPackages().get(0).getLocation() + " and date "
                + packageGroup.getPackages().get(0).getDeliveryDate().toString() + " in " + packageGroup.getPackages().get(0).getDistance() + " seconds");
    }
}

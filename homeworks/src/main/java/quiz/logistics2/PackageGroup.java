package quiz.logistics2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@ToString
public class PackageGroup {

    private List<Package> packages = new ArrayList<>();
    private int groupRevenue;
    private int groupValue;


    public void addToGroup(Package pack) {
        packages.add(pack);
    }

    public void calculateGroupRevenueAndValue() {
        for (Package pack : packages
        ) {
            groupRevenue += pack.getDistance();
            groupValue += pack.getValue();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackageGroup that = (PackageGroup) o;
        return groupRevenue == that.groupRevenue &&
                groupValue == that.groupValue &&
                Objects.equals(packages, that.packages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packages, groupRevenue, groupValue);
    }
}

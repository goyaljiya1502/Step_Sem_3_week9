package Week9;

import java.util.Scanner;

interface Insurable {
    double getInsurance();
}

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double getCharge();

    double getTotal() {
        double insurance = 0;

        if (this instanceof Insurable)
            insurance = ((Insurable) this).getInsurance();

        return getCharge() + insurance;
    }
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double getCharge() {
        return 40 + 10 * weight;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double getCharge() {
        return 80 + 15 * weight;
    }

    public double getInsurance() {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double getCharge() {
        return 40 + 10 * weight + 50;
    }

    public double getInsurance() {
        return declaredValue * 0.02;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            Parcel parcel;

            if (type.equals("STANDARD"))
                parcel = new StandardParcel(weight, value);
            else if (type.equals("EXPRESS"))
                parcel = new ExpressParcel(weight, value);
            else
                parcel = new FragileParcel(weight, value);

            double charge = parcel.getCharge();
            double insurance = 0;

            if (parcel instanceof Insurable)
                insurance = ((Insurable) parcel).getInsurance();

            double total = parcel.getTotal();
            grandTotal += total;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}

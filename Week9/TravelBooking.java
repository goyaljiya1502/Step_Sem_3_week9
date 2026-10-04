package Week9;

import java.util.Scanner;

abstract class Booking {
    protected double distance;
    private static final double BOOKING_FEE = 50;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double getBaseFare();

    double getTotal() {
        return getBaseFare() + BOOKING_FEE;
    }
}

class Bus extends Booking {
    Bus(double distance) {
        super(distance);
    }

    double getBaseFare() {
        return distance * 2;
    }
}

class Train extends Booking {
    Train(double distance) {
        super(distance);
    }

    double getBaseFare() {
        return distance * 1.5;
    }
}

class Flight extends Booking {
    Flight(double distance) {
        super(distance);
    }

    double getBaseFare() {
        return 2500 + distance * 4;
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            Booking booking;

            if (mode.equals("BUS")) {
                booking = new Bus(distance);
            } else if (mode.equals("TRAIN")) {
                booking = new Train(distance);
            } else {
                booking = new Flight(distance);
            }

            System.out.printf("%s: %.2f%n", mode, booking.getTotal());
        }

        sc.close();
    }
}

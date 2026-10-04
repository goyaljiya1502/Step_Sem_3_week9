package Week9;

import java.util.Scanner;

abstract class Staff {
    protected String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double getPay();
}

class FullTime extends Staff {
    private double salary;

    FullTime(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    double getPay() {
        return salary;
    }
}

class Hourly extends Staff {
    private double hours;
    private double rate;

    Hourly(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double getPay() {
        if (hours <= 40)
            return hours * rate;
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class Intern extends Staff {
    private double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double getPay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Staff staff;

            if (type.equals("FULLTIME")) {
                staff = new FullTime(name, sc.nextDouble());
            } else if (type.equals("HOURLY")) {
                staff = new Hourly(name, sc.nextDouble(), sc.nextDouble());
            } else {
                staff = new Intern(name, sc.nextDouble());
            }

            double pay = staff.getPay();
            total += pay;
            System.out.printf("%s: %.2f%n", staff.name, pay);
        }

        System.out.printf("Total Payroll: %.2f%n", total);
        sc.close();
    }
}

package Week9;

import java.util.Scanner;

abstract class Ticket {
    protected int count;
    private static final double FEE = 20;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPrice();

    double getAmount() {
        return count * (getPrice() + FEE);
    }
}

class RegularTicket extends Ticket {
    RegularTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 150;
    }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 250;
    }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 400;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();
            Ticket ticket;

            if (seat.equals("REGULAR"))
                ticket = new RegularTicket(count);
            else if (seat.equals("PREMIUM"))
                ticket = new PremiumTicket(count);
            else
                ticket = new ReclinerTicket(count);

            double amount = ticket.getAmount();
            total += amount;

            System.out.printf("%s: %.2f%n", seat, amount);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

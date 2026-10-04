package Week9;

import java.util.Scanner;

abstract class Plot {
    protected String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double getArea();
    abstract String getShape();
}

class Circle extends Plot {
    private double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double getArea() {
        return Math.PI * radius * radius;
    }

    String getShape() {
        return "CIRCLE";
    }
}

class Rectangle extends Plot {
    private double length;
    private double width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double getArea() {
        return length * width;
    }

    String getShape() {
        return "RECTANGLE";
    }
}

class Triangle extends Plot {
    private double base;
    private double height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double getArea() {
        return 0.5 * base * height;
    }

    String getShape() {
        return "TRIANGLE";
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            Plot plot;

            if (shape.equals("CIRCLE")) {
                plot = new Circle(owner, sc.nextDouble());
            } else if (shape.equals("RECTANGLE")) {
                plot = new Rectangle(owner, sc.nextDouble(), sc.nextDouble());
            } else {
                plot = new Triangle(owner, sc.nextDouble(), sc.nextDouble());
            }

            double area = plot.getArea();
            total += area;
            System.out.printf("%s (%s): %.2f%n", plot.owner, plot.getShape(), area);
        }

        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}

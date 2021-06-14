package com.figures;
import java.io.FileWriter;
import java.util.*;
import java.io.*;

public class Main {
    public static void writeToFile(Figure f, String fileName) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(f.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Circle circle = new Circle(5);
        System.out.println(circle);

        Square square = new Square(5);
        System.out.println(square);

        Rectangle rectangle = new Rectangle(4, 8);
        System.out.println(rectangle);

        Triangle triangle = new Triangle(s);
        System.out.println(triangle);

        EqualTriangle equalTriangle = new EqualTriangle(5);
        System.out.println(equalTriangle);

        Rhombus rhombus = new Rhombus(3, 4);
        System.out.println(rhombus);

        Parallelogram parallelogram = new Parallelogram(s);
        System.out.println(parallelogram);

        Trapezoid trapezoid = new Trapezoid(s);
        System.out.println(trapezoid);

        TreeSet<Figure> availableFiguresT = new TreeSet<Figure>();
        availableFiguresT.add(circle);
        availableFiguresT.add(rhombus);
        availableFiguresT.add(rectangle);
        availableFiguresT.add(square);
        availableFiguresT.add(equalTriangle);

        System.out.println("\n# TreeSet comparison with Comparable by area:");
        for (Figure f : availableFiguresT) {
            System.out.println(f.getClass().getSimpleName() + " with area of " + f.getArea());
        }

        AreaComparator facomp = new AreaComparator();
        List<Figure> availableFiguresA = new ArrayList<Figure>();
        availableFiguresA.add(circle);
        availableFiguresA.add(rhombus);
        availableFiguresA.add(rectangle);
        availableFiguresA.add(square);
        availableFiguresA.add(equalTriangle);

        availableFiguresA.sort(facomp);

        System.out.println("\n# ArrayList comparison:");
        for (Figure f : availableFiguresA) {
            System.out.println(f.getClass().getSimpleName() + " with area of " + f.getArea());
        }

        writeToFile(circle, "circle1.txt");
    }
}

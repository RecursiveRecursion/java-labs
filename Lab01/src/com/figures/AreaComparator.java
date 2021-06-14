package com.figures;
import java.util.Comparator;

public class AreaComparator implements Comparator<Figure> {
    public int compare(Figure f1, Figure f2) {
        return -Double.compare(f1.getArea(), f2.getArea());
    }
}
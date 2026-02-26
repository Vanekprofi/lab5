package ru.shulepov.geometry;

import java.util.Arrays;

/**
 * Ломаная линия
 */
public class Polyline {
    private final Point[] points;

    public Polyline(Point[] points) {
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Линия [" + String.join(",", Arrays.toString(points)).replaceAll("[\\[\\]]", "") + "]";
    }
}
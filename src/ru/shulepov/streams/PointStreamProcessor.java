package ru.shulepov.streams;

import ru.shulepov.geometry.Point;
import ru.shulepov.geometry.Polyline;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Обработка точек через Stream API
 */
public class PointStreamProcessor {

    /**
     * Обработать точки: убрать дубликаты, отсортировать по X, сделать Y положительными
     */
    public static Polyline processPoints(List<Point> points) {
        if (points == null || points.isEmpty()) {
            return new Polyline(new Point[0]);
        }

        Point[] result = points.stream()
                .distinct()
                .sorted(Comparator.comparingInt(Point::getX))
                .map(p -> new Point(p.getX(), Math.abs(p.getY())))
                .toArray(Point[]::new);

        return new Polyline(result);
    }
}
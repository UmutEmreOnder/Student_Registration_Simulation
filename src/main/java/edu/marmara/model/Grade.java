package edu.marmara.model;

import java.util.HashMap;
import java.util.Map;

public enum Grade {
    AA(4.0), BA(3.5), BB(3.0), CB(2.5), CC(2.0), DC(1.5), DD(1.0), FD(0.5), FF(0.0);

    private static final Map<Double, Grade> map = new HashMap<>();

    static {
        for (Grade point : Grade.values()) {
            map.put(point.grade, point);
        }
    }

    private Double grade;

    Grade(Double grade) {
        this.grade = grade;
    }

    public static String valueOfGrade(Double point) {
        return map.get(point).name();
    }
}
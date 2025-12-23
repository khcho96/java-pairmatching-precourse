package pairmatching.domain;

import pairmatching.constant.Course;

public class Crew {

    private final String name;
    private final Course course;

    private Crew(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public static Crew of(String name, Course course) {
        return new Crew(name, course);
    }
}

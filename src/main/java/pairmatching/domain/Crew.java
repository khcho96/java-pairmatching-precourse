package pairmatching.domain;

import pairmatching.constant.Course;

public class Crew {

    private final String name;
    private final Course course;

    public Crew(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public static Crew from(String name, Course course) {
        return new Crew(name, course);
    }

    public String getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }
}

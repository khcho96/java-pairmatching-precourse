package pairmatching.domain;

import java.util.Objects;
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

    public String getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Crew crew = (Crew) object;
        return Objects.equals(name, crew.name) && course == crew.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, course);
    }
}

package pairmatching.domain;

import java.util.Objects;
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

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Crew crew = (Crew) object;
        return Objects.equals(name, crew.name) && course == crew.course;
    }
}

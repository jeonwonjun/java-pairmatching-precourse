package pairmatching.model.crew;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Course getCourse(String course) {
        return Arrays.stream(values())
                .filter(c -> c.name.equals(course))
                .findFirst()
                .get();
    }
}
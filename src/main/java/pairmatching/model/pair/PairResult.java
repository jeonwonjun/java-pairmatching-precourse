package pairmatching.model.pair;

import java.util.ArrayList;
import java.util.List;
import pairmatching.model.crew.Course;
import pairmatching.model.crew.Crew;
import pairmatching.model.crew.Level;
import pairmatching.model.crew.Mission;

public class PairResult {
    private List<Pair> pairList = new ArrayList<>();
    private final Course course;
    private final Level level;
    private final Mission mission;

    public PairResult(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public void addPairResult(Pair pair) {
        pairList.add(pair);
    }

    public List<Pair> getPairList() {
        return pairList;
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }
}

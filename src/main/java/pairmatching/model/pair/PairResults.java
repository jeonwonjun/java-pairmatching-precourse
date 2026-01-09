package pairmatching.model.pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pairmatching.model.crew.Course;
import pairmatching.model.crew.Level;
import pairmatching.model.crew.Mission;

public class PairResults {
    private List<PairResult> pairResultList = new ArrayList<>();

    public void addList(PairResult pairResult) {
        pairResultList.add(pairResult);
    }

    public PairResult findByInfo(Course course, Level level, Mission mission) {
        return pairResultList.stream()
                .filter(p -> (p.getCourse() == course && p.getLevel() == level && p.getMission() == mission))
                .reduce((first, second) -> second)
                .orElse(null);
    }

    public void clearList() {
        pairResultList.clear();
    }

    public List<PairResult> getPairResultList() {
        return pairResultList;
    }
}

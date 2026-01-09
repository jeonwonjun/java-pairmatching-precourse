package pairmatching.model.pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

    public List<Pair> findAllByCourseAndLevel(Course course, Level level) {
        return pairResultList.stream()
                .filter(p -> p.getCourse() == course && p.getLevel() == level)
                .flatMap(p -> p.getPairList().stream())
                .collect(Collectors.toList());
    }

    public void clearList() {
        pairResultList.clear();
    }

    public List<PairResult> getPairResultList() {
        return pairResultList;
    }
}

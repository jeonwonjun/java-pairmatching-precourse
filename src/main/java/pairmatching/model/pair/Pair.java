package pairmatching.model.pair;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private List<String> pair = new ArrayList<>();

    public void add(String crewName) {
        pair.add(crewName);
    }

    public List<String> getPair() {
        return pair;
    }
}

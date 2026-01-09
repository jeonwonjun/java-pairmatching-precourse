package pairmatching.model.pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Pair {
    private List<String> pair = new ArrayList<>();

    public void add(String crewName) {
        pair.add(crewName);
    }

    public boolean isSamePair(Pair other) {
        if (this.pair.size() != other.getPair().size()) {
            return false;
        }
        return new HashSet<>(this.pair).containsAll(other.getPair());
    }

    public List<String> getPair() {
        return pair;
    }
}

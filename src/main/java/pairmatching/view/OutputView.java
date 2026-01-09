package pairmatching.view;

import java.util.List;
import pairmatching.model.pair.Pair;
import pairmatching.model.pair.PairResult;
import pairmatching.model.pair.PairResults;

public class OutputView {
    public static void printList(List<Pair> pairs) {
        System.out.println();
        System.out.println("페어 매칭 결과입니다.");
        for (Pair pair : pairs) {
            String result = String.join(" : ", pair.getPair());
            System.out.println(result);
        }
        System.out.println();
    }
}

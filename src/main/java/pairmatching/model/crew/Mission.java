package pairmatching.model.crew;

import java.util.Arrays;
import pairmatching.util.ErrorMessage;

public enum Mission {
    RACING_CAR(Level.LEVEL1, "자동차경주"),
    LOTTO(Level.LEVEL1, "로또"),
    BASEBALL_GAME(Level.LEVEL1, "숫자야구게임"),
    BASKET(Level.LEVEL2, "장바구니"),
    PURCHASE(Level.LEVEL2, "결제"),
    SUBWAY(Level.LEVEL2, "지하철노선도"),
    IMPROVEMENT(Level.LEVEL4, "성능개선"),
    DISTRIBUTE(Level.LEVEL4, "배포"),
    ;

    private final Level level;
    private final String name;

    Mission(Level level, String name) {
        this.level = level;
        this.name = name;
    }

    public static Mission getMission(Level missionLevel, String missionName) {
        return Arrays.stream(values())
                .filter(m -> m.level == missionLevel && m.name.equals(missionName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_MISSION_EXISTS.getMessage()));
    }
}

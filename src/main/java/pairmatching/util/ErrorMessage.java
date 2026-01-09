package pairmatching.util;

public enum ErrorMessage {
    INVALID_EMPTY("입력값이 비어있습니다."),
    INVALID_WHITESPACE("입력값에 공백이 포함될 수 없습니다."),
    INVALID_DELIMITER("구분자가 누락되었거나 위치가 올바르지 않습니다."),
    INVALID_DUPLICATE("중복된 값이 존재합니다."),

    INVALID_NUMERIC("숫자만 입력 가능합니다."),

    NON_MATCHING_HISTORY("매칭 이력이 없습니다."),
    MATCHING_FAIL("매칭할 수 없습니다."),

    INVALID_FILE_READ("파일을 읽는 중 오류가 발생했습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
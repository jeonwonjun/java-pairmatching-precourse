package pairmatching.view;

import java.util.List;
import pairmatching.util.ErrorMessage;

public class InputValidator {

    // 빈 칸 및 Null 검증
    public static void validateEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_EMPTY.getMessage());
        }
    }

    // 앞뒤 공백 포함 검증 (trim 후 값과 비교)
    public static void validateNoWhitespace(String input) {
        if (input.length() != input.trim().length()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WHITESPACE.getMessage());
        }
    }

    // 구분자 포함 여부 및 올바른 분리 검증 (예: 쉼표)
    public static void validateDelimiter(String input, String delimiter) {
        if (!input.contains(delimiter)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER.getMessage());
        }
    }

    // 리스트 내 중복 문자열 검증
    public static void validateNoDuplicate(List<String> inputs) {
        long distinctCount = inputs.stream().distinct().count();
        if (inputs.size() != distinctCount) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATE.getMessage());
        }
    }

    public static int validateNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMERIC.getMessage());
        }
    }
}
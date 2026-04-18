package com.ironlogic.ironlogic.dto;

/**
 * 공통 응답 규격 관리 클래스
 * @param <T> 응답 데이터 타입
 */
import java.time.LocalDateTime;

public class ApiResponse<T> {
    private final boolean success;   // 요청 처리 결과
    private final String message;    // 처리 메시지
    private final T data;            // 반환 데이터
    private final LocalDateTime timestamp; // 응답 생성 시각

    private ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

    // 데이터 포함 성공 응답
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, "Operation Successful", data);
    }

    // 메시지 커스텀 성공 응답
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(true, message, data);
    }

    // 예외 상황 발생 시 실패 응답
    public static <T> ApiResponse<T> fail(String message) {
        return new ApiResponse<>(false, message, null);
    }
}

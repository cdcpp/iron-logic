package com.toy.ironlogic.dto;

import com.toy.ironlogic.domain.LiftType;
import com.toy.ironlogic.domain.ProgramType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProgramSetupRequest {
    @NotNull(message = "운동 종목은 필수입니다.")
    private LiftType liftType;

    @NotNull(message = "1RM 무게는 필수입니다.")
    @Positive(message = "1RM은 0보다 커야합니다.")
    private Double oneRm;

    @NotNull(message = "프로그램 선택은 필수입니다.")
    private ProgramType programType;
}

package com.toy.ironlogic.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Data
public class OneRmSaveRequest {
    @NotNull private Long memberId;
    @NotNull private Integer cycle;

    @Positive private Double squat;
    @Positive private Double benchPress;
    @Positive private Double deadlift;
    @Positive private Double overheadPress;

}

package com.toy.ironlogic.dto;

import com.toy.ironlogic.domain.ProgramType;
import lombok.Data;

@Data
public class RoutineRequest {
    private Double oneRm;
    private ProgramType programType;
}

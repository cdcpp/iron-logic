package com.toy.ironlogic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeeklySet {
    private int week;
    private double weight;
    private int reps;
    private double percent;
}

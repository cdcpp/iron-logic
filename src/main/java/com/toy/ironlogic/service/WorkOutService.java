package com.toy.ironlogic.service;

import com.toy.ironlogic.domain.ProgramType;
import com.toy.ironlogic.dto.WeeklySet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WorkOutService {
    /**
     * 1RM과 프로그램 타입(Enum)을 받아서 3주치 루틴을 계산한다.
     */
    public List<WeeklySet> calculateRoutine(Double oneRm, ProgramType type) {
        List<WeeklySet> routine = new ArrayList<>();

        // Tranig Max (90%)
        double tm = oneRm * 0.9;


        double[] percents = type.getPercents();
        int[] reps = type.getReps();

        return IntStream.range(0, 3)
                .mapToObj(i -> {
                    // 비즈니스 로직 (계산)
                    double rawWeight = tm * percents[i];
                    double finalWeight = Math.round(rawWeight / 2.5) * 2.5; // 2.5kg 반올림

                    // 결과 객체 매핑 (Mapping)
                    return new WeeklySet(
                            i + 1,          // 주차
                            finalWeight,    // 무게
                            reps[i],        // 횟수
                            percents[i]     // 퍼센트
                    );
                })
                .toList();
    }
}

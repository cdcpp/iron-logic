package com.toy.ironlogic.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProgramType {
    // [전략 패턴] 각 타입이 자신의 '비율'과 '횟수' 데이터를 가짐
    // 5/3/1: 스트렝스 (저반복 고중량)
    TYPE_531(new double[]{0.65, 0.75, 0.85}, new int[]{5, 3, 1}, "스트렝스"),

    // 8/6/3 : 근비대
    TYPE_863(new double[]{0.70, 0.80, 0.90}, new int[]{8, 6, 3}, "근비대");

    private final double[] percents; // 1, 2, 3주차 비율
    private final int[] reps;        // 1, 2, 3주차 목표 횟수
    private final String description; // 설명

}

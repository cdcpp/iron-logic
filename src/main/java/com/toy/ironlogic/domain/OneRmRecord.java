package com.toy.ironlogic.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
        name = "one_rm",
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "uk_member_lift_cycle",
                    columnNames = {"member_id" , "cycle"}
            )
        }
)
public class OneRmRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long memberId; //  회원 ID만 저장... 멤버 만들고 member로 변경.


    private Double squat;
    private Double benchPress;
    private Double deadlift;
    private Double overheadPress;

    @Column(nullable = false)
    private Double weight; // 1RM 무게 (kg)

    @Column(nullable = false)
    private Integer cycle; // 루틴 사이클(1,2,3,4,~~~)

    private LocalDate recordDate; // 저장날짜

    @Builder
    public OneRmRecord(Long memberId, Integer cycle, Double squat, Double benchPress, Double deadlift, Double overheadPress, LocalDate recordDate) {
        this.memberId = memberId;
        this.cycle = cycle;
        this.squat = squat;
        this.benchPress = benchPress;
        this.deadlift = deadlift;
        this.overheadPress = overheadPress;
        this.recordDate = recordDate;
    }

    //1rm 수정 메소드
    public void updateWeights(Double squat, Double benchPress, Double deadlift, Double overheadPress) {
        this.squat = Objects.requireNonNullElse(squat, this.squat);
        this.benchPress = Objects.requireNonNullElse(benchPress, this.benchPress);
        this.deadlift = Objects.requireNonNullElse(deadlift, this.deadlift);
        this.overheadPress = Objects.requireNonNullElse(overheadPress, this.overheadPress);
        this.recordDate = LocalDate.now();
    }

}

package com.ironlogic.ironlogic.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "one_rep_max")
public class OneRepMax extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //몇회차인지
    private int session;

    //4대운동 1rm
    private Double squat;
    private Double benchPress;
    private Double deadlift;
    private Double overheadPress;

    private Double totalWeight;


    private Double calculateTotal() {
        return (squat != null ? squat : 0) +
                (benchPress != null ? benchPress : 0) +
                (deadlift != null ? deadlift : 0) +
                (overheadPress != null ? overheadPress : 0);
    }

}

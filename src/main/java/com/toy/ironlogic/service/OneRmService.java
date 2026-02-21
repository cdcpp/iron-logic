package com.toy.ironlogic.service;

import com.toy.ironlogic.domain.OneRmRecord;
import com.toy.ironlogic.dto.OneRmSaveRequest;
import com.toy.ironlogic.repository.OneRmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OneRmService {

    private final OneRmRepository oneRmRepository;

    @Transactional
    public Long saveOrUpdate(OneRmSaveRequest request){

        return oneRmRepository.findByMemberIdAndCycle(request.getMemberId(), request.getCycle())
                .map(record -> {
                    //존재한다면 수정
                    record.updateWeights(
                            request.getSquat(),
                            request.getBenchPress(),
                            request.getDeadlift(),
                            request.getOverheadPress()
                    );
                    return record.getId();
                })
                .orElseGet(() -> {
                    //존재하지 않다면 생성
                    OneRmRecord newOneRm = OneRmRecord.builder()
                            .memberId(request.getMemberId())
                            .cycle(request.getCycle())
                            .squat(request.getSquat())
                            .deadlift(request.getDeadlift())
                            .overheadPress(request.getOverheadPress())
                            .recordDate(LocalDate.now())
                            .build();
                    return oneRmRepository.save(newOneRm).getId();
        });

    }

}

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
    public Long save(OneRmSaveRequest request) {
        OneRmRecord record = OneRmRecord.builder()
                .memberId(request.getMemberId())
                .cycle(request.getCycle())
                .squat(request.getSquat())
                .benchPress(request.getBenchPress())
                .deadlift(request.getDeadlift())
                .overheadPress(request.getOverheadPress())
                .build();
        return oneRmRepository.save(record).getId();
    }

    @Transactional
    public void update(Long id, OneRmSaveRequest request) {
        OneRmRecord record = oneRmRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 기록입니다."));

        record.updateWeights(
                request.getSquat(),
                request.getBenchPress(),
                request.getDeadlift(),
                request.getOverheadPress()
        );
    }

    @Transactional
    public void delete(Long id) {
        oneRmRepository.deleteById(id);
    }

}

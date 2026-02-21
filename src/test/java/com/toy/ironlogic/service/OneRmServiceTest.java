package com.toy.ironlogic.service;

import com.toy.ironlogic.dto.OneRmSaveRequest;
import com.toy.ironlogic.domain.OneRmRecord;
import com.toy.ironlogic.repository.OneRmRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class OneRmServiceTest {

    @Autowired OneRmService oneRmService;
    @Autowired OneRmRepository oneRmRepository;

    @Test
    @DisplayName("1RM 기록 저장 및 수정(upsert...merge...) 테스트")
    void saveOrUpdateTest() {
        // 1. Given
        OneRmSaveRequest request = new OneRmSaveRequest();
        request.setMemberId(1L);
        request.setCycle(1);
        request.setSquat(100.0);
        request.setBenchPress(80.0);
        request.setDeadlift(140.0);
        request.setOverheadPress(60.0);

        // 2. When
        Long savedId = oneRmService.saveOrUpdate(request);

        // 3. Then
        OneRmRecord findRecord = oneRmRepository.findById(savedId).get();
        assertThat(findRecord.getSquat()).isEqualTo(100.0);
        assertThat(findRecord.getCycle()).isEqualTo(1);

        // 4. And When: 무게수정
        request.setSquat(110.0); //
        oneRmService.saveOrUpdate(request);

        // 5. Final Then: row count 확인(1) , 스쿼트 무게 확인
        OneRmRecord updatedRecord = oneRmRepository.findByMemberIdAndCycle(1L, 1).get();
        assertThat(updatedRecord.getSquat()).isEqualTo(110.0);
        assertThat(oneRmRepository.count()).isEqualTo(1);
    }
}
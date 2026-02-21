package com.toy.ironlogic.repository;

import com.toy.ironlogic.domain.OneRmRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OneRmRepository extends JpaRepository<OneRmRecord, Long> {
    // 회원번호로 사이클 조회
    Optional<OneRmRecord> findByMemberIdAndCycle(Long memberId, Integer cycle);
}

package com.toy.ironlogic.controller;

import com.toy.ironlogic.dto.OneRmSaveRequest;
import com.toy.ironlogic.service.OneRmService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/one-rms")
public class OneRmController {

    private final OneRmService oneRmService;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody @Valid OneRmSaveRequest request) {
        Long id = oneRmService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody @Valid OneRmSaveRequest request) {
        oneRmService.update(id, request);
        return ResponseEntity.noContent().build(); // 204 No Content: 성공했지만 돌려줄 데이터는 없음
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        oneRmService.delete(id);
        return ResponseEntity.noContent().build();
    }



}

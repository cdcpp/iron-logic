package com.toy.ironlogic.controller;

import com.toy.ironlogic.dto.ProgramSetupRequest;
import com.toy.ironlogic.dto.WeeklySet;
import com.toy.ironlogic.service.WorkOutService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programs")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "https://iron-logic.ttt")
public class ProgramController {

    private final WorkOutService workOutService;

    @PostMapping("/setup")
    public List<WeeklySet> setupRoutine(@RequestBody @Valid ProgramSetupRequest request){

        return workOutService.calculateRoutine(
                request.getOneRm(),
                request.getLiftType(),
                request.getProgramType()
        );
    }

}

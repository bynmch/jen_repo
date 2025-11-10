package com.ohgiraffers.bootproject.controller;

import com.ohgiraffers.bootproject.dto.CalculatorDto;
import com.ohgiraffers.bootproject.entity.CalculationHistory;
import com.ohgiraffers.bootproject.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class CalculatorController {
    CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "젠킨스 건강합니다~~~ 굿 먼데이";
    }

//    @GetMapping("/plus")
//    public ResponseEntity<CalculatorDto> plusTwoNumbers(CalculatorDto calculatorDto) {
//        log.info("calculatorDto = {}", calculatorDto);
//        int result = service.plusTwoNumbers(calculatorDto);
//        calculatorDto.setSum(result);
//
//        return ResponseEntity.ok().body(calculatorDto);
//    }

    @PostMapping("/plus")
    public ResponseEntity<CalculatorDto> plusTwoNumbers(@RequestBody CalculatorDto calculatorDto) {
        log.info("calculatorDto = {}", calculatorDto);
        int result = calculatorService.plusTwoNumbers(calculatorDto);
        calculatorDto.setSum(result);

        return ResponseEntity.ok().body(calculatorDto);
    }

    @GetMapping("/history")
    public ResponseEntity<List<CalculationHistory>> getHistory() {
        log.info("계산 이력 조회 요청");
        List<CalculationHistory> historyList = calculatorService.getAllHistory();
        return ResponseEntity.ok().body(historyList);
    }
}

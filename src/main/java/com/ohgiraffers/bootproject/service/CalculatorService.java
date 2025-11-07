package com.ohgiraffers.bootproject.service;

import com.ohgiraffers.bootproject.dto.CalculatorDto;
import com.ohgiraffers.bootproject.entity.CalculationHistory;
import com.ohgiraffers.bootproject.repository.CalculationHistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class CalculatorService {

    private CalculationHistoryRepository calculationHistoryRepository;

    @Autowired
    public CalculatorService(CalculationHistoryRepository calculationHistoryRepository) {
        this.calculationHistoryRepository = calculationHistoryRepository;
    }

    @Transactional
    public int plusTwoNumbers(CalculatorDto calculatorDto) {
//        return calculatorDto.getNum1() + calculatorDto.getNum2();
        int result = calculatorDto.getNum1() + calculatorDto.getNum2();

        // 계산 결과를 DB에 저장
        CalculationHistory history =
                new CalculationHistory(calculatorDto.getNum1(), calculatorDto.getNum2(), result);

        calculationHistoryRepository.save(history);
        log.info("계산 이력 저장 완료: {}", history);
        return result;
    }

    public List<CalculationHistory> getAllHistory() {
        return calculationHistoryRepository.findAllByOrderByCreatedAtDesc();
    }
}

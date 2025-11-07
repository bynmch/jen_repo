package com.ohgiraffers.bootproject.dto;

import lombok.*;

@ToString
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class CalculatorDto {
    @NonNull
    private Integer num1;
    @NonNull
    private Integer num2;
    private int sum;
}

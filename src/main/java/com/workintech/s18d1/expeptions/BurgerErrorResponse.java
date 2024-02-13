package com.workintech.s18d1.expeptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BurgerErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}

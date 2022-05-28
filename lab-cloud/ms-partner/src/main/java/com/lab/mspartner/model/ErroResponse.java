package com.lab.mspartner.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErroResponse {

    private String erro;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    private Integer status;

}

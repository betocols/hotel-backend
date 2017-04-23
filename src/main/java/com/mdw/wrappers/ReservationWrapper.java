package com.mdw.wrappers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.Instant;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationWrapper {

    private Long id;

    private String reservationCode;

    @NotNull
    private Long roomId;

    @NotNull
    private Long numberOfPersons;

    private Instant reservationDate;

}

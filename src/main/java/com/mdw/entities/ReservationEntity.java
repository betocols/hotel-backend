package com.mdw.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation")
public class ReservationEntity {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    @Column(name = "reservation_code", unique = true, nullable = false)
    private String reservationCode;

    @OneToOne
    @JoinColumn(name = "room_id", nullable = false)
	private RoomEntity room;

    @Column(name = "person_count", nullable = false)
    private Long numberOfPersons;

    @Column(name = "reservation_date", nullable = false)
    private Instant reservationDate;

    @OneToOne
    @JoinColumn(name = "confirmation_id", nullable = false)
    private ConfirmEntity confirmation;
}


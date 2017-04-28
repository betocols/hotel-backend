package com.mdw.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "confirm")
public class ConfirmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "confirm_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "pay_type_id", nullable = false)
    private PayTypeEntity payType;

    @Column(name = "confirmation_number", nullable = false)
    private String ConfirmationNumber;

    @Column(name = "bank", nullable = false)
    private String bank;

}

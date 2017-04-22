package com.mdw.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "room_type")
public class RoomTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_type_id")
    private Long id;

    @Column(name = "room_type", nullable = false)
    private String type;

    @Column(name = "price", nullable = false)
    private Double price;

    @OneToMany(mappedBy = "type")
    private List<RoomEntity> rooms;

    @Column(name = "bathrooms", nullable = false)
    private Long bathrooms;

    @Column(name = "has_tv", nullable = false)
    private Boolean hasTv;

    @Column(name = "has_wifi", nullable = false)
    private Boolean hasWifi;

    @Column(name = "has_heating", nullable = false)
    private Boolean hasHeating;

    @Column(name = "has_air_conditioning", nullable = false)
    private Boolean hasAirConditioning;

}

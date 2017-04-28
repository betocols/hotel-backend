package com.mdw.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"hotel", "type"})
@EqualsAndHashCode(exclude = {"hotel", "type"})
@Entity
//@Proxy(lazy = false)
@Table(name = "room", uniqueConstraints = @UniqueConstraint(columnNames = {"hotel_id", "room_number"}))
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_type_id", nullable = false)
    private RoomTypeEntity type;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private HotelEntity hotel;

    @Column(name = "room_number", nullable = false)
    private String roomNumber;

    @Column(name = "single_beds", nullable = false)
    private Long singleBedCount;

    @Column(name = "double_beds", nullable = false)
    private Long doubleBedCount;

    @Column(name = "queen_beds", nullable = false)
    private Long queenBedCount;

    @Column(name = "king_beds", nullable = false)
    private Long kingBedCount;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "room_id", nullable = false)
    private List<RoomImageEntity> images = new ArrayList();
}

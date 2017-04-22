package com.mdw.entities;

import javax.persistence.*;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "hotel")
@EqualsAndHashCode(exclude = "hotel")
@Entity
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "room_id", nullable = false)
    private List<RoomImageEntity> images;

}

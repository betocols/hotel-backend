package com.mdw.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "hotelChain")
@EqualsAndHashCode(exclude = "hotelChain")
@Entity
@Table(name = "hotel")
public class HotelEntity {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotel_id")
	private Long id;

    @Column(name = "hotel_name", nullable = false)
	private String name;

    @Column(name = "address_line", nullable = false)
    private String addressLine;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "province", nullable = false)
    private String province;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "hotel_chain_id")
    private HotelChainEntity hotelChain;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "hotel_id", nullable = false)
    private List<HotelImageEntity> images;

    @OneToMany(mappedBy = "hotel")
    private List<RoomEntity> rooms;

}

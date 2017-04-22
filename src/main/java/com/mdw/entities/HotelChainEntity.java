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
@Table(name = "hotel_chain")
public class HotelChainEntity {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotel_chain_id")
	private Long id;

    @Column(name = "hotel_chain_name", nullable = false)
	private String name;

    @OneToOne
    @JoinColumn(name = "logo_id")
    private ImageEntity logo;

    @OneToMany(mappedBy = "hotelChain")
    private List<HotelEntity> hotels;

}

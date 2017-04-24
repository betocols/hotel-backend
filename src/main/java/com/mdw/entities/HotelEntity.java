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
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "hotelChain")
@EqualsAndHashCode(exclude = "hotelChain")
@Entity
//@Proxy(lazy = false)
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
    private HotelChainEntity hotelChain = new HotelChainEntity();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "hotel_id", nullable = false)
    private List<HotelImageEntity> images = new ArrayList();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "hotel")
    private List<RoomEntity> rooms = new ArrayList();

}

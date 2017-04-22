package com.mdw.wrappers;

import com.mdw.entities.ImageEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomWrapper {

    private Long id;

    private Long hotelId;

    private String roomType;

    private double price;

    private Long singleBedCount;

    private Long doubleBedCount;

    private Long queenBedCount;

    private Long kingBedCount;

    private Long bathrooms;

    private Boolean hasTv;

    private Boolean hasWifi;

    private Boolean hasHeating;

    private Boolean hasAirConditioning;

    private List<String> images;

}

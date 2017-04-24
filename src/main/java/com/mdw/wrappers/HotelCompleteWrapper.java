package com.mdw.wrappers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelCompleteWrapper {

    private Long id;
    private String name;
    private String addressLine;
    private String city;
    private String province;
    private String zipCode;
    private String hotelChainName;
    private List<RoomWrapper> rooms;
}

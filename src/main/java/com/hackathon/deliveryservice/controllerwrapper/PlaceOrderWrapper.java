package com.hackathon.deliveryservice.controllerwrapper;

import lombok.*;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PlaceOrderWrapper {

    private long userId;
    private String sourceAddress;
    private String destAddress;
    private String date;
    private Map<Integer, Integer> itemMap;


}

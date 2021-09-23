package com.hackathon.deliveryservice.controllerwrapper;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddItemWrapper {

    private long userId;
    private String itemName;
    private int price;
}

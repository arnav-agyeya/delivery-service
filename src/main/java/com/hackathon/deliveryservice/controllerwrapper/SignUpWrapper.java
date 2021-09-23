package com.hackathon.deliveryservice.controllerwrapper;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignUpWrapper {

    private String name;
    private String phNo;
    private String email;
    private String username;
    private String pwd;
    private boolean isAdmin;

}

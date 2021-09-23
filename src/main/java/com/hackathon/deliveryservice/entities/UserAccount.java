package com.hackathon.deliveryservice.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user_account")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String name;

    @Column(name = "mobilenumber", unique = true)
    private String mobileNumber;

    @Column(name = "emailid", unique = true)
    private String emailId;

    private boolean isAdmin;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return Objects.equals(userId, that.userId) && Objects.equals(name, that.name) && Objects.equals(mobileNumber, that.mobileNumber) && Objects.equals(emailId, that.emailId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, mobileNumber, emailId);
    }
}

package com.hackathon.deliveryservice.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
@Table(name = "login_user")
public class LoginUser {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private UserAccount user;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String passWord;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LoginUser loginUser = (LoginUser) o;
        return Objects.equals(id, loginUser.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}

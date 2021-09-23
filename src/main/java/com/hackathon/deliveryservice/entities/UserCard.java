package com.hackathon.deliveryservice.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user_card")
public class UserCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_card_id", nullable = false)
    private Long id;

    @OneToOne
    private UserAccount userAccount;

    private int points;

    @OneToMany
    @ToString.Exclude
    private List<CardTransaction> transactionList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserCard userCard = (UserCard) o;
        return Objects.equals(id, userCard.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}

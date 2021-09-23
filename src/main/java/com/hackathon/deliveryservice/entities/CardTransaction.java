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
@Table(name = "card_transaction")
public class CardTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_card_id")
    private UserCard userCard;

    @OneToOne
    private Order order;

    private boolean transactionType;

    private int points;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CardTransaction that = (CardTransaction) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
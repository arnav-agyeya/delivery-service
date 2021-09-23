package com.hackathon.deliveryservice.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private UserAccount user;
    private String sourceAddress;
    private String destinationAddress;
    private LocalDate orderTime;

    @OneToMany
    @ToString.Exclude
    private List<ItemQuant> itemQuantList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public int getPrice() {
        return itemQuantList.stream()
                .map(itemQuant -> itemQuant.getItem().getItemPrice()* itemQuant.getSize())
                .mapToInt(i->i)
                .sum();
    }
}

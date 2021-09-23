package com.hackathon.deliveryservice.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;


@ToString
@NoArgsConstructor
@Getter
@Setter
@Table(name = "item_quant")
@Entity
public class ItemQuant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private int size;

    @JoinColumn(name = "item_ID")
    @OneToOne
    private Item item;

    public ItemQuant(Item item,
                     Integer value) {
        this.size = value;
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ItemQuant itemQuant = (ItemQuant) o;
        return Objects.equals(id, itemQuant.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
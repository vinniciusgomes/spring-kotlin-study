package com.jetherrodrigues.unisal.domain.store;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "store")
public final class Store implements Serializable {

    @Id
    @SequenceGenerator(name = "store_id_seq", sequenceName = "store_id_seq", allocationSize = 1)
    @GeneratedValue(generator="store_id_seq", strategy=GenerationType.SEQUENCE)
    @Column(name = "store_id")
    private long id;
    @Column(unique = true)
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public Store(){}

    public Store(final String name) {
        this.name = name;
        this.created = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return id == store.id &&
                name.equals(store.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created +
                '}';
    }
}

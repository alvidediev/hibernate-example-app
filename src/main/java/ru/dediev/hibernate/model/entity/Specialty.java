package ru.dediev.hibernate.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "specialty")
public class Specialty implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialty_id")
    private Long id;
    @Column(name = "specialty_name")
    private String name;
    @OneToMany(mappedBy = "specialty")
    private List<Developer> developers = new ArrayList<>();
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public Specialty(String name, Status status) {
        this.name = name;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}

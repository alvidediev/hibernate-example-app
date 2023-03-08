package ru.dediev.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "specialty")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SpecialtyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialty_id")
    private Long id;
    @Column(name = "specialty_name")
    private String name;
    @OneToMany(mappedBy = "specialtyEntity")
    private List<DeveloperEntity> developerEntities = new ArrayList<>();
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public SpecialtyEntity(String name, Status status) {
        this.name = name;
        this.status = status;
    }

    @Override
    public String toString() {
        return "SpecialtyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}

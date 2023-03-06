package ru.dediev.hibernate.model.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "skill")
@Setter
@Getter
public class Skill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Long id;

    @Column(name = "skill_name")
    private String name;

    @ManyToMany(mappedBy = "skill")
    List<Developer> developers = new ArrayList<>();

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public Skill(String name, Status status) {
        this.name = name;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }

    public Skill() {
    }
}

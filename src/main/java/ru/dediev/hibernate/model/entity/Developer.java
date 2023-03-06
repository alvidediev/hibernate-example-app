package ru.dediev.hibernate.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "developers")
@Setter
@Getter
public class Developer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "developer_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
            @JoinTable(
                    name = "developers_skills",
                    joinColumns = {@JoinColumn(name = "developers_skills_developer_id")},
                    inverseJoinColumns = {@JoinColumn(name = "developers_skills_skill_id")}
            )
    private List<Skill> skill = new ArrayList<>();


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private Status status;


    public Developer(String firstName, String lastName, List<Skill> skill, Specialty specialty, Status status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.skill = skill;
        this.specialty = specialty;
        this.status = status;
    }

    public Developer() {
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", skill=" + skill +
                ", specialty=" + specialty +
                ", status=" + status +
                '}';
    }
}

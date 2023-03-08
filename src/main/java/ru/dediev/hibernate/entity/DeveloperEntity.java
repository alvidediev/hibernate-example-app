package ru.dediev.hibernate.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "developers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DeveloperEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "developer_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
            @JoinTable(
                    name = "developers_skills",
                    joinColumns = {@JoinColumn(name = "developers_skills_developer_id")},
                    inverseJoinColumns = {@JoinColumn(name = "developers_skills_skill_id")}
            )
    private List<SkillEntity> skillEntity = new ArrayList<>();


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specialty_id")
    private SpecialtyEntity specialtyEntity;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public DeveloperEntity(String firstName, String lastName, List<SkillEntity> skillEntity, SpecialtyEntity specialtyEntity, Status status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.skillEntity = skillEntity;
        this.specialtyEntity = specialtyEntity;
        this.status = status;
    }

    @Override
    public String toString() {
        return "DeveloperEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", skillEntity=" + skillEntity +
                ", specialtyEntity=" + specialtyEntity +
                ", status=" + status +
                '}';
    }
}

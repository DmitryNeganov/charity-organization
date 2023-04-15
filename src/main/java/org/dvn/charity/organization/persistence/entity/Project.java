package org.dvn.charity.organization.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "projects")
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false, length = 50)
    private String projectName;

    @Column(nullable = false)
    private int involvementDegree; //1, 2, 3, 4, 5

    @Column(nullable = false)
    private int budget;

    @Column(nullable = false)
    private boolean isActive;

}

package org.dvn.charity.organization.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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
    private int participationCoefficient;

    @Column(nullable = false)
    private int budget;

    @Column(nullable = false)
    private boolean isActive;

}

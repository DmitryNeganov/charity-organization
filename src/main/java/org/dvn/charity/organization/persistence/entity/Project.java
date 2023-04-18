package org.dvn.charity.organization.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

/**
 * The type Project.
 */
@Entity
@Table(name = "projects")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false, length = 50)
    private String projectName;

    @Column(nullable = false)
    private int involvementDegree; //1, 2, 3, 4, 5

    @Column(nullable = false)
    private float budget;

    @Column(nullable = false)
    private boolean isActive;

}

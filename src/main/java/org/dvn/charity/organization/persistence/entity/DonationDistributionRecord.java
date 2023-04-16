package org.dvn.charity.organization.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Donation distribution record.
 */
@Entity
@Table(name = "donation_distribution_records")
@Getter
@Setter
public class DonationDistributionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    private Project project;

    @Column(nullable = false)
    private float distributedSum;

    @ManyToOne
    private Donation donation;
}

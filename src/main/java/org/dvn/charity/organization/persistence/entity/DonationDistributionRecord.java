package org.dvn.charity.organization.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private int sum;

    @ManyToOne
    private Donation donation;
}

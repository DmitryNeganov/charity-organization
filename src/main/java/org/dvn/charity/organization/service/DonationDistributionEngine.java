package org.dvn.charity.organization.service;

import lombok.RequiredArgsConstructor;
import org.dvn.charity.organization.persistence.entity.Donation;
import org.dvn.charity.organization.persistence.entity.DonationDistributionRecord;
import org.dvn.charity.organization.persistence.entity.Project;
import org.dvn.charity.organization.persistence.repository.DonationDistributionRecordRepo;
import org.springframework.stereotype.Service;

/**
 * The type Donation distribution engine.
 */
@Service
@RequiredArgsConstructor
public class DonationDistributionEngine {
    private final ProjectService projectService;
    private final DonationDistributionRecordRepo donationDistributionRecordRepo;

    /**
     * Distribute donation.
     *
     * @param donation the donation
     */
    public void distributeDonation(Donation donation) {
        float degreesSum = projectService.getAllInvolvementDegreesSum();
        var projectList = projectService.getAllProjects();
        for (Project project : projectList) {
            float donationDistribution = donation.getDonationFullSum() / degreesSum * project.getInvolvementDegree();
            float newBudget = project.getBudget() + donationDistribution;
            project.setBudget(newBudget);
            var record = new DonationDistributionRecord();
            record.setProject(project);
            record.setDistributedSum(donationDistribution);
            record.setDonation(donation);
            donationDistributionRecordRepo.save(record);
        }
    }
}

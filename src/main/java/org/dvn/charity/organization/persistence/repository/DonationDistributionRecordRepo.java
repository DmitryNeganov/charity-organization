package org.dvn.charity.organization.persistence.repository;

import org.dvn.charity.organization.persistence.entity.DonationDistributionRecord;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Donation distribution record repo.
 */
public interface DonationDistributionRecordRepo extends CrudRepository<DonationDistributionRecord, Long> {
}

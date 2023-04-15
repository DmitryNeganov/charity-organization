package org.dvn.charity.organization.persistence.repository;

import org.dvn.charity.organization.persistence.entity.DonationDistributionRecord;
import org.springframework.data.repository.CrudRepository;

public interface DonationDistributionRecordRepo extends CrudRepository<DonationDistributionRecord, Long> {
}

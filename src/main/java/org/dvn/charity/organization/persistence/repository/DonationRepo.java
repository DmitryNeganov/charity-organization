package org.dvn.charity.organization.persistence.repository;

import org.dvn.charity.organization.persistence.entity.Donation;
import org.springframework.data.repository.CrudRepository;

public interface DonationRepo extends CrudRepository<Donation, Long> {
}

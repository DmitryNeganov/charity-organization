package org.dvn.charity.organization.persistence.repository;

import org.dvn.charity.organization.persistence.entity.Donation;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Donation repo.
 */
public interface DonationRepo extends CrudRepository<Donation, Long> {
}

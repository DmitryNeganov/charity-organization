package org.dvn.charity.organization.persistence.repository;

import org.dvn.charity.organization.persistence.entity.Sponsor;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Sponsor repo.
 */
public interface SponsorRepo extends CrudRepository<Sponsor, Long> {

    boolean existsBySponsorName(String sponsorName);
    Sponsor findBySponsorName(String sponsorName);

}

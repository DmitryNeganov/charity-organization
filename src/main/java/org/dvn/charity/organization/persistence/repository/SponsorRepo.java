package org.dvn.charity.organization.persistence.repository;

import org.dvn.charity.organization.persistence.entity.Sponsor;
import org.springframework.data.repository.CrudRepository;

public interface SponsorRepo extends CrudRepository<Sponsor, Long> {
}

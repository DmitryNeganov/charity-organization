package org.dvn.charity.organization.service;

import lombok.RequiredArgsConstructor;
import org.dvn.charity.organization.persistence.entity.Sponsor;
import org.dvn.charity.organization.persistence.repository.SponsorRepo;
import org.springframework.stereotype.Service;

/**
 * The type Sponsor service.
 */
@Service
@RequiredArgsConstructor
public class SponsorService {

    private final SponsorRepo sponsorRepo;

    /**
     * Create or user exsisting sponsor sponsor.
     *
     * @param sponsorName the sponsor name
     * @return the sponsor
     */
    public Sponsor createOrUserExsistingSponsor(String sponsorName) {
        if (sponsorRepo.existsBySponsorName(sponsorName)) {
            return sponsorRepo.findBySponsorName(sponsorName);
        }
        return new Sponsor(sponsorName);
    }
}

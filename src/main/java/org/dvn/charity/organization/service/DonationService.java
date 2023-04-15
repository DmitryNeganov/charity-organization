package org.dvn.charity.organization.service;

import lombok.RequiredArgsConstructor;
import org.dvn.charity.organization.persistence.repository.DonationRepo;
import org.dvn.charity.organization.persistence.repository.SponsorRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DonationService {

    private final DonationRepo donationRepository;
    private final SponsorRepo sponsorRepository;


}

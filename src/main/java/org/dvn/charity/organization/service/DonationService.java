package org.dvn.charity.organization.service;

import lombok.RequiredArgsConstructor;
import org.dvn.charity.organization.persistence.entity.Donation;
import org.dvn.charity.organization.persistence.repository.DonationRepo;
import org.dvn.charity.organization.persistence.repository.SponsorRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonationService {

    private final DonationRepo donationRepository;
    private final SponsorRepo sponsorRepository;

    public List<Donation> getAllDonations() {
        return (List<Donation>) donationRepository.findAll();
    }

    public Donation getDonationById(long id) {
        return donationRepository.findById(id).orElse(null);
    }

    public Donation createDonation(Donation donation) {
        return donationRepository.save(donation);
    }
}

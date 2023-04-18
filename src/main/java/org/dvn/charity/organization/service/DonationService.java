package org.dvn.charity.organization.service;

import lombok.RequiredArgsConstructor;
import org.dvn.charity.organization.api.dto.DonationDto;
import org.dvn.charity.organization.persistence.entity.Donation;
import org.dvn.charity.organization.persistence.entity.Sponsor;
import org.dvn.charity.organization.persistence.repository.DonationRepo;
import org.dvn.charity.organization.persistence.repository.SponsorRepo;
import org.dvn.charity.organization.service.mapper.DonationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * The type Donation service.
 */
@Service
@RequiredArgsConstructor
public class DonationService {

    private final DonationRepo donationRepository;
    private final DonationMapper donationMapper;
    private final DonationDistributionEngine donationDistributionEngine;
    private final SponsorRepo sponsorRepo;

    /**
     * Gets all donations.
     *
     * @return the all donations
     */
    public List<Donation> getAllDonations() {
        return (List<Donation>) donationRepository.findAll();
    }

    /**
     * Gets donation by id.
     *
     * @param id the id
     * @return the donation by id
     */
    public Optional<Donation> getDonationById(long id) {
        return donationRepository.findById(id);
    }

    /**
     * Create donation donation.
     *
     * @param donationDto the donation dto
     * @return the donation
     */
    @Transactional
    public Donation createDonation(DonationDto donationDto) {
        Donation donation = donationMapper.map(donationDto);
        donationDistributionEngine.distributeDonation(donation);
        return donationRepository.save(donation);
    }
}

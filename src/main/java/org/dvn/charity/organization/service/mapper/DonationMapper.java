package org.dvn.charity.organization.service.mapper;

import lombok.RequiredArgsConstructor;
import org.dvn.charity.organization.api.dto.DonationDto;
import org.dvn.charity.organization.persistence.entity.Donation;
import org.dvn.charity.organization.service.SponsorService;
import org.springframework.stereotype.Service;

/**
 * The type Donation mapper.
 */
@Service
@RequiredArgsConstructor
public class DonationMapper {
    private final SponsorService sponsorService;

    /**
     * Map donation.
     *
     * @param donationDto the donation dto
     * @return the donation
     */
    public Donation map(DonationDto donationDto) {
        var donation = new Donation();
        donation.setDonationFullSum(donationDto.getDonationFullSum());
        donation.setSponsor(sponsorService.createNewOrUseExsistingSponsor(donationDto.getSponsorName()));

        return donation;
    }
}

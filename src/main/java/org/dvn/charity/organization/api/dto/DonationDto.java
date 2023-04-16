package org.dvn.charity.organization.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

/**
 * The type Donation dto.
 */
@Getter
public class DonationDto {

    @NotBlank(message = "Donation sum must be positive number")
    @Min(value = 0, message = "Donation sum must be positive number")
    private float donationFullSum;

    @NotBlank(message = "Name of the sponsor is mandatory")
    @Size(max = 50, message = "Name of the sponsor must be less than 50 characters")
    private String sponsorName;
}

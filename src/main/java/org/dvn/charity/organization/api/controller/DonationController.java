package org.dvn.charity.organization.api.controller;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.dvn.charity.organization.api.dto.DonationDto;
import org.dvn.charity.organization.persistence.entity.Donation;
import org.dvn.charity.organization.service.DonationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Donation controller.
 */
@RestController
@RequestMapping(value = "/donations")
@RequiredArgsConstructor
public class DonationController {

    private final DonationService donationService;

    /**
     * Find all donations list.
     *
     * @return the list of donations
     */
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all donations list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Donation not found"),
            @ApiResponse(code = 500, message = "Internal error")})
    public List<Donation> findAllDonations() {
        return donationService.getAllDonations();
    }

    /**
     * Gets donation by id.
     *
     * @param id the id
     * @return the donation by id
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get donation by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Donation not found"),
            @ApiResponse(code = 500, message = "Internal error")})
    public Donation getDonationById(@PathVariable("id") long id) {
        return donationService.getDonationById(id);
    }

    /**
     * Create donation donation.
     *
     * @param donationDto the donation dto
     * @return the donation
     */
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new donation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created"),
            @ApiResponse(code = 400, message = "Missing or invalid request body"),
            @ApiResponse(code = 500, message = "Internal error")})
    public Donation createDonation(@RequestBody DonationDto donationDto) {
        return donationService.createDonation(donationDto);
    }
}

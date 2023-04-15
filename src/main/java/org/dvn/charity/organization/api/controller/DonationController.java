package org.dvn.charity.organization.api.controller;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.dvn.charity.organization.persistence.entity.Donation;
import org.dvn.charity.organization.service.DonationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/donations")
@RequiredArgsConstructor
public class DonationController {

    private final DonationService donationService;

    @GetMapping("/")
    public List<Donation> findAllDonations() {
        return null;
    }

    @GetMapping("/{id}")
    public Donation getDonationById(@PathVariable("id") long id) {
        return null;
    }

    @PostMapping("/")
    @Operation
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created"),
            @ApiResponse(code = 400, message = "Missing or invalid request body"),
            @ApiResponse(code = 500, message = "Internal error")})
    public Donation createDonation() {
        return null;
    }

}

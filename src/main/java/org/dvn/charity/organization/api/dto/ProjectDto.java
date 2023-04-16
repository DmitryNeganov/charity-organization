package org.dvn.charity.organization.api.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

/**
 * The type Project dto.
 */
@Getter
public class ProjectDto {

    @NotBlank(message = "Name of the project is mandatory")
    @Size(max = 50, message = "Name of the project must be less than 50 characters")
    private String projectName;

    @NotBlank(message = "Involvement degree is mandatory")
    @Min(value = 1, message = "Involvement degree must be integer number from 1 to 5")
    @Max(value = 5, message = "Involvement degree must be integer number from 1 to 5")
    private int involvementDegree; //1, 2, 3, 4, 5

    @NotBlank(message = "Budget must be positive number")
    @Min(value = 0, message = "Budget must be positive number")
    private float startingBudget;

}

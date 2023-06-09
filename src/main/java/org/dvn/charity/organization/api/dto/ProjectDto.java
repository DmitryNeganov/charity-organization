package org.dvn.charity.organization.api.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Project dto.
 */
@Getter
@Setter
public class ProjectDto {

    @NotBlank(message = "Name of the project is mandatory")
    @Size(max = 50, message = "Name of the project must be less than 50 characters")
    private String projectName;

    @NotNull(message = "Involvement degree is mandatory")
    @Min(value = 1, message = "Involvement degree must be integer number from 1 to 5")
    @Max(value = 5, message = "Involvement degree must be integer number from 1 to 5")
    private Integer involvementDegree; //1, 2, 3, 4, 5

    @NotNull(message = "Budget must be positive number")
    @Min(value = 0, message = "Budget must be positive number")
    private Float startingBudget;

}

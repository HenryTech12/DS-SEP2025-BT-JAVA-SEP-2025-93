package org.manage.trip.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Constraint;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.manage.trip.annotations.DateRange;
import org.manage.trip.validation.DateRangeValidator;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DateRange(startDate = "startDate", endDate = "endDate")
public class TripRequest {
    @NotBlank(message = "destination can't be blank")
    private String destination;
    @NotNull(message = "startDate cannot be null")
    private LocalDate startDate;
    private LocalDate endDate;
    @Min(value = 0)
    private Double price;
    private TripStatus status;
}

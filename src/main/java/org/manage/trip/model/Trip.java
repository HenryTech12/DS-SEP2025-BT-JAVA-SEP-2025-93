package org.manage.trip.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.manage.trip.dto.TripStatus;

import java.time.LocalDate;

@Data
@Entity
@Builder
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double price;
    private TripStatus status;
}

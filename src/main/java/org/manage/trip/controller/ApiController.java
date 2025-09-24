package org.manage.trip.controller;

import jakarta.validation.Valid;
import org.manage.trip.dto.TripRequest;
import org.manage.trip.dto.TripStatus;
import org.manage.trip.pagination.TripPageRequest;
import org.manage.trip.response.TripSummary;
import org.manage.trip.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class ApiController {

    @Autowired
    private TripService tripService;
    @PostMapping("/")
    public ResponseEntity<TripRequest> createTrip(@RequestBody @Valid TripRequest tripRequest) {
        return new ResponseEntity<>(tripService.createTrip(tripRequest), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Page<TripRequest>> getTrips(TripPageRequest tripPageRequest) {
        return new ResponseEntity<>(tripService.getTrips(tripPageRequest),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripRequest> getTripByID(@PathVariable Long id) {
        return new ResponseEntity<>(tripService.getTripByID(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TripRequest> updateTripByID(@PathVariable Long id, @RequestBody @Valid TripRequest tripRequest) {
        return new ResponseEntity<>(tripService.updateTripById(id,tripRequest),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTripByID(@PathVariable Long id) {
        tripService.deleteTripByID(id);
        return new ResponseEntity<>(String.format("Trip data with id : %d data removed",id),HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<TripRequest>> searchTripByDestination(String destination) {
        return new ResponseEntity<>(tripService.searchTripByDestination(destination),HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TripRequest>> filterTripByStatus(TripStatus status) {
        return new ResponseEntity<>(tripService.filterByStatus(status),HttpStatus.OK);
    }

    @GetMapping("/daterange")
    public ResponseEntity<List<TripRequest>> findTripBetweenDate(String startDate, String endDate) {
        System.out.println(startDate);
        return new ResponseEntity<>(tripService.findTripBetweenDates(
                LocalDate.parse(startDate),LocalDate.parse(endDate)),HttpStatus.OK);
    }

    @GetMapping("/summary")
    public ResponseEntity<TripSummary> getSummary() {
        return new ResponseEntity<>(tripService.getSummary(),HttpStatus.OK);
    }
}

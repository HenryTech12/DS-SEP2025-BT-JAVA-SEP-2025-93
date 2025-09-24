package org.manage.trip.service;

import lombok.extern.slf4j.Slf4j;
import org.manage.trip.dto.TripRequest;
import org.manage.trip.dto.TripStatus;
import org.manage.trip.exception.TripDataNotFound;
import org.manage.trip.mapper.TripMapper;
import org.manage.trip.model.Trip;
import org.manage.trip.pagination.TripPageRequest;
import org.manage.trip.repository.TripRepository;
import org.manage.trip.response.TripSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class TripService {

    @Autowired
    private TripMapper tripMapper;
    @Autowired
    private TripRepository tripRepository;

    public TripRequest createTrip(TripRequest tripRequest) {
        Trip trip = tripMapper.convertToModel(tripRequest);
        if(exists(trip)) {
            tripRepository.save(trip);
            log.info("trip data saved to database");
            return tripRequest;
        }
        return null;
    }

    public Page<TripRequest> getTrips(TripPageRequest tripPageRequest) {
            return tripRepository.findAll(tripPageRequest.getPageRequest())
                    .map(tripMapper::convertToRequest);
    }

    boolean exists(Trip trip) {
       return (!Objects.isNull(getTripByID(trip.getId())));
    }

    public TripRequest getTripByID(Long id) {
        return tripRepository.findById(id)
                .map(tripMapper::convertToRequest).orElseThrow(() ->
                        new TripDataNotFound(String.format("Trip Data with ID: %d Not Found.",id)));
    }

    public TripRequest updateTripById(Long id, TripRequest newRequest) {
        Trip trip = tripRepository.findById(id)
                .orElseThrow(() -> new TripDataNotFound(String.format("Trip Data with ID: %d Not Found.",id)));
        Trip newTripData = tripMapper.convertToModel(newRequest);
        newTripData.setId(trip.getId());

        tripRepository.save(newTripData);
        log.info("Trip with id: {} data updated..", id);
        return newRequest;
    }

    public void deleteTripByID(Long id) {
        tripRepository.findById(id).orElseThrow(() -> new TripDataNotFound(
                String.format("Trip Data with ID: %d Not Found.",id)));
        tripRepository.deleteById(id);
        log.info("Trip with id: {} data removed", id);
    }

    public List<TripRequest> searchTripByDestination(String destination) {
        return tripRepository.findByDestination(destination)
                .stream().map(tripMapper::convertToRequest).toList();
    }

    public List<TripRequest> filterByStatus(TripStatus status) {
        return tripRepository.findByStatus(status)
                .stream().map(tripMapper::convertToRequest).toList();
    }

    public List<TripRequest> findTripBetweenDates(LocalDate startDate, LocalDate endDate) {
        return tripRepository.findByBetweenStartDateAndEndDate(startDate,endDate)
                .stream().map(tripMapper::convertToRequest).toList();
    }

    public TripSummary getSummary() {
        return TripSummary.builder()
                .totalTrips(tripRepository.findCount())
                .minPrice(tripRepository.findMinPrice())
                .maxPrice(tripRepository.findMaxPrice())
                .averagePrice(tripRepository.findAveragePrice())
                .build();
    }
}

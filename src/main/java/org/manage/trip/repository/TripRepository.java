package org.manage.trip.repository;

import org.manage.trip.dto.TripStatus;
import org.manage.trip.model.Trip;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip,Long> {
    List<Trip> findByDestination(String destination);

    @Query("SELECT t FROM Trip t WHERE t.startDate BETWEEN :startDate AND :endDate")
    List<Trip> findByBetweenStartDateAndEndDate(LocalDate startDate, LocalDate endDate);
    @Query("SELECT COUNT(*) FROM Trip")
    int findCount();
    @Query("SELECT MIN(t.price) FROM Trip t")
    Double findMinPrice();
    @Query("SELECT MAX(t.price) FROM Trip t")
    Double findMaxPrice();
    @Query("SELECT AVG(t.price) FROM Trip t")
    Double findAveragePrice();
    List<Trip> findByStatus(TripStatus status);
}

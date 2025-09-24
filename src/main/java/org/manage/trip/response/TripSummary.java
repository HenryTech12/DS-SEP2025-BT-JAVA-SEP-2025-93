package org.manage.trip.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TripSummary {
    private int totalTrips;
    private Double minPrice;
    private Double maxPrice;
    private Double averagePrice;
}

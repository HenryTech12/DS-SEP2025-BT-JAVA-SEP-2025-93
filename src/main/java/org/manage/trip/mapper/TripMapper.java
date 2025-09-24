package org.manage.trip.mapper;

import org.manage.trip.dto.TripRequest;
import org.manage.trip.model.Trip;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TripMapper {

    @Autowired
    private ModelMapper mapper;

    public TripRequest convertToRequest(Trip trip){
        if(!Objects.isNull(trip))
            return mapper.map(trip, TripRequest.class);
        else
            return null;
    }

    public Trip convertToModel(TripRequest tripRequest) {
        if(!Objects.isNull(tripRequest))
            return mapper.map(tripRequest, Trip.class);
        else
            return null;
    }
}

package org.manage.trip.pagination;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Objects;

@Slf4j
@Data
@Builder
public class TripPageRequest {

    private int pageNo = 0;
    private int pageSize = 10;
    private String sortBy = "destination";
    private Sort.Direction sortDir = Sort.Direction.ASC;

    public Pageable getPageRequest() {
        log.info("page request details includes: {}", this);
        return PageRequest.
                of(pageNo,
                        pageSize,sortDir
                        ,sortBy);
    }
}

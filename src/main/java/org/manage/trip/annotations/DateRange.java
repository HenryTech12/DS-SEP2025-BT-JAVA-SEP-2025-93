package org.manage.trip.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.manage.trip.validation.DateRangeValidator;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateRangeValidator.class)
public @interface DateRange {

    String message() default "end_date can't be greater than start_date";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String startDate();
    String endDate();
}

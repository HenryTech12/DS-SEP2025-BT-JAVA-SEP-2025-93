package org.manage.trip.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.manage.trip.annotations.DateRange;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class DateRangeValidator implements ConstraintValidator<DateRange, Object> {

    private String startDate;
    private String endDate;
    @Override
    public void initialize(DateRange constraintAnnotation) {
        startDate = constraintAnnotation.startDate();
        endDate = constraintAnnotation.endDate();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        try {
            Field startDateField = value.getClass().getDeclaredField(startDate);
            Field endDateField = value.getClass().getDeclaredField(endDate);

            startDateField.setAccessible(true);
            endDateField.setAccessible(true);
            LocalDate startDateValue = (LocalDate) startDateField.get(value);
            LocalDate endDateValue = (LocalDate) endDateField.get(value);

            System.out.println(startDateValue);
            System.out.println(endDateValue);
            return endDateValue.isAfter(startDateValue);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

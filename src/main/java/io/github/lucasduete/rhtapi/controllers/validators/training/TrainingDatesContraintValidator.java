package io.github.lucasduete.rhtapi.controllers.validators.training;

import io.github.lucasduete.rhtapi.models.Training;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

/**
 * Implemention of {@link TrainingDatesValidator} to {@link Training}
 */
@Component
public class TrainingDatesContraintValidator implements ConstraintValidator<TrainingDatesValidator, Training> {

    public TrainingDatesContraintValidator() {

    }

    @Override
    public boolean isValid(final Training training, final ConstraintValidatorContext constraintValidatorContext) {
        final LocalDate dateStart = training.getDateStart();
        final LocalDate dateFinish = training.getDateFinish();

        /**
         * Both Dates can't be before today
         */
        if (dateStart.isBefore(LocalDate.now()) || dateFinish.isBefore(LocalDate.now())) {
            return false;
        }

        /**
         * DateFinish must be after or equals to DateStart
         */
        if (dateFinish.isBefore(dateStart)) {
            return false;
        }

        /**
         * Otherwise is valid
         */
        return true;
    }

}

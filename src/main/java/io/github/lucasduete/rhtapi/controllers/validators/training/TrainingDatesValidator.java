package io.github.lucasduete.rhtapi.controllers.validators.training;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Annotation that validate:
 * 1. Both Dates can't be before today
 * 2. DateFinish must be after or equals to DateStart
 */
@Documented
@Constraint(validatedBy = TrainingDatesContraintValidator.class)
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE_PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface TrainingDatesValidator {

    String message() default "As datas são inválidas, a data de inicio e fim devem ser no mínimo a data de hoje. A data final deve ser posterior a data de inicio.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
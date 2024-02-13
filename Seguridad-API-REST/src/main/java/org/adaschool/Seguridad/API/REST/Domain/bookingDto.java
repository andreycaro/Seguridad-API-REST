package org.adaschool.Seguridad.API.REST.Domain;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record bookingDto(
        String id,
        String state,
        Integer quantity,
        user user
) {
}

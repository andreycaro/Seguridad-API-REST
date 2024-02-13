package org.adaschool.Seguridad.API.REST.Domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface bookingRepository extends MongoRepository<booking, String> {
}

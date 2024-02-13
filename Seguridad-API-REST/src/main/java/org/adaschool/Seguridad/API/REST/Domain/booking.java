package org.adaschool.Seguridad.API.REST.Domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "booking")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class booking {
    @Id
    private String id;
    private String state;
    private Integer quantity;

    @DBRef
    private user user;
}

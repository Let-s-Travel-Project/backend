package com.letsTravel.LetsTravel.domain.map.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Country {

    @Id
    @Column(columnDefinition = "CHAR(2)", nullable = false)
    private String countryCode;

    @Column(columnDefinition = "VARCHAR(40)", nullable = false, unique = true)
    private String countryName;

    @Column(columnDefinition = "VARCHAR(30)", nullable = false, unique = true)
    private String countryNameTranslated;

}

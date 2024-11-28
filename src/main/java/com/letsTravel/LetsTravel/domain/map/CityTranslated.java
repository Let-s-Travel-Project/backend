package com.letsTravel.LetsTravel.domain.map;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CityTranslated {

    @Id
    @Column(columnDefinition = "SMALLINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(columnDefinition = "VARCHAR(85)", nullable = false)
    private String cityName;

    @Column(columnDefinition = "VARCHAR(2)", nullable = false)
    private String languageCode;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

}
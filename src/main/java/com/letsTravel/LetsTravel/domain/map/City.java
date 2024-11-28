package com.letsTravel.LetsTravel.domain.map;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class City {

    @Id
    @Column(columnDefinition = "SMALLINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(columnDefinition = "VARCHAR(85)", nullable = false)
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "country_code", nullable = false)
    private Country country;

}
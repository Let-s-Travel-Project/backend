package com.letsTravel.LetsTravel.domain.map;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Locality {

    @Id
    @Column(columnDefinition = "MEDIUMINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR(58)", nullable = false)
    private String localityName;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

}
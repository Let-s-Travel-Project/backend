package com.letsTravel.LetsTravel.domain.map;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Place {

    @Id
    @Column(columnDefinition = "INT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "locality_id", nullable = false)
    private Locality locality;

    @ManyToOne
    @JoinColumn(name = "poi_id", nullable = false)
    private Poi poi;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false, unique = true)
    private String uniqueIdentifier;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false, unique = true)
    private String placeName;

    @Column(columnDefinition = "DECIMAL(8, 6)", nullable = false, unique = true)
    private float latitude;

    @Column(columnDefinition = "DECIMAL(8, 6)", nullable = false, unique = true)
    private float longitude;

}

package com.letsTravel.LetsTravel.domain.map.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @JoinColumn(columnDefinition = "MEDIUMINT", name = "locality_id", nullable = false)
    private Locality locality;

    @ManyToOne
    @JoinColumn(name = "poi_id", nullable = false)
    private Poi poi;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false, unique = true)
    private String uniqueIdentifier;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String placeName;

    @Column(columnDefinition = "DECIMAL(8, 6)", nullable = false)
    private double latitude;

    @Column(columnDefinition = "DECIMAL(8, 6)", nullable = false)
    private double longitude;

}

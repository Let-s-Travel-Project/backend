package com.letsTravel.LetsTravel.domain.map.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LocalityTranslated {

    @Id
    @Column(columnDefinition = "MEDIUMINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR(58)", nullable = false)
    private String localityName;

    @Column(columnDefinition = "VARCHAR(2)", nullable = false)
    private String languageCode;

    @ManyToOne
    @JoinColumn(name = "locality_id", nullable = false)
    private Locality locality;

}
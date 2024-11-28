package com.letsTravel.LetsTravel.domain.map;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PlaceTranslated {

    @Id
    @Column(columnDefinition = "INT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR(85)", nullable = false)
    private String placeName;

    @Column(columnDefinition = "VARCHAR(2)", nullable = false)
    private String languageCode;

    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;

}


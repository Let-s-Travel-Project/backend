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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String placeName;

    @Column(length = 10, nullable = false)
    private String languageCode;

    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;

}


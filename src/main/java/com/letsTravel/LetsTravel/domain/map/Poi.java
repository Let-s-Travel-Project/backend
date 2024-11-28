package com.letsTravel.LetsTravel.domain.map;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Poi {

    @Id
    @Column(columnDefinition = "TINYINT UNSIGNED")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(columnDefinition = "VARCHAR(16)", nullable = false, unique = true)
    private String poiName;

    @Column(columnDefinition = "VARCHAR(20)", nullable = false, unique = true)
    private String poiNameTranslated;

}
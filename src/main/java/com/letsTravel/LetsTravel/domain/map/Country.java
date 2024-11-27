package com.letsTravel.LetsTravel.domain.map;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Country {

    @Id
    @Column(length = 3, nullable = false)
    private String countryCode;

    @Column(length = 100, nullable = false)
    private String countryName;

}

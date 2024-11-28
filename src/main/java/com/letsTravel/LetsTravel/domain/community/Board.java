package com.letsTravel.LetsTravel.domain.community;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Board {

    @Id
    @Column(columnDefinition = "TINYINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(30)", nullable = false)
    private String boardName;

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private String category;

}

package com.letsTravel.LetsTravel.domain.plan;

import com.letsTravel.LetsTravel.domain.map.Place;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Schedule {

    @Id
    @Column(columnDefinition = "INT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private Plan plan;

    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private byte dayNumber;

    @Column(columnDefinition = "TIME", nullable = false)
    private LocalTime time;

}
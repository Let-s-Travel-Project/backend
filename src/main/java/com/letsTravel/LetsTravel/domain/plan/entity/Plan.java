package com.letsTravel.LetsTravel.domain.plan.entity;

import com.letsTravel.LetsTravel.domain.map.entity.Country;
import com.letsTravel.LetsTravel.domain.profile.entity.Profile;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(
        name = "plan",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"user_id", "planName"}
                )
        }
)
public class Plan {

    @Id
    @Column(columnDefinition = "INT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "country_code", nullable = false)
    private Country country;

    @Column(columnDefinition = "VARCHAR(15)", nullable = false)
    private String planName;

    @Column(columnDefinition = "DATE", nullable = false)
    private Date startDate;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private byte durationDays;

}
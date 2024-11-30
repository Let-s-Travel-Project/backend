package com.letsTravel.LetsTravel.domain.plan.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SharedPlan {

    @EmbeddedId
    @Column(columnDefinition = "INT")
    private SharedPlanId id;

}
package com.letsTravel.LetsTravel.domain.plan;

import com.letsTravel.LetsTravel.domain.profile.Profile;
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
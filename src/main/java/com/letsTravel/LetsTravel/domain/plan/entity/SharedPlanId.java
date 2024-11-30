package com.letsTravel.LetsTravel.domain.plan.entity;

import com.letsTravel.LetsTravel.domain.profile.entity.Profile;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class SharedPlanId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private Plan plan;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Profile profile;


}
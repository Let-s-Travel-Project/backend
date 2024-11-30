package com.letsTravel.LetsTravel.domain.community.entity;

import com.letsTravel.LetsTravel.domain.profile.entity.Profile;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class LikeId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

}

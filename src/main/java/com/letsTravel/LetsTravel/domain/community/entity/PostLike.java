package com.letsTravel.LetsTravel.domain.community.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostLike {

    @EmbeddedId
    private LikeId likeId;

}
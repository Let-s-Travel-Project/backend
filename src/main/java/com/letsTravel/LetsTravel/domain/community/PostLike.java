package com.letsTravel.LetsTravel.domain.community;

import com.letsTravel.LetsTravel.domain.profile.Profile;
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
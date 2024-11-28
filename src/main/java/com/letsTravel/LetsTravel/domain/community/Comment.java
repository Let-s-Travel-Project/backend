package com.letsTravel.LetsTravel.domain.community;

import com.letsTravel.LetsTravel.domain.profile.Profile;
import com.letsTravel.LetsTravel.domain.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Comment extends BaseTimeEntity {

    @Id
    @Column(columnDefinition = "INT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Profile profile;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

}
package com.letsTravel.LetsTravel.domain.community;

import com.letsTravel.LetsTravel.domain.profile.Profile;
import com.letsTravel.LetsTravel.domain.plan.Plan;
import com.letsTravel.LetsTravel.domain.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Post extends BaseTimeEntity {

    @Id
    @Column(columnDefinition = "INT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @Column(columnDefinition = "VARCHAR(30)", nullable = false)
    private String postTitle;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

}
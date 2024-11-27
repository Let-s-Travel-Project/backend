package com.letsTravel.LetsTravel.domain.community;

import com.letsTravel.LetsTravel.domain.profile.User;
import com.letsTravel.LetsTravel.domain.scheme.Plan;
import com.letsTravel.LetsTravel.domain.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @Column(length = 255, nullable = false)
    private String postTitle;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

}
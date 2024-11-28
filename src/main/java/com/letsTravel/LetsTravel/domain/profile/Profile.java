package com.letsTravel.LetsTravel.domain.profile;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Profile {

    @Id
    @Column(columnDefinition = "INT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "VARCHAR(60)", nullable = false, unique = true)
    private String username;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String password;
    @Column(columnDefinition = "VARCHAR(15)", nullable = false)
    private String firstName;
    @Column(columnDefinition = "VARCHAR(15)", nullable = false)
    private String lastName;
    @Column(columnDefinition = "VARCHAR(15)", nullable = false, unique = true)
    private String nickname;
    @Column(columnDefinition = "Date")
    private Date birth;
    @Column(columnDefinition = "TINYINT")
    private Boolean sex;
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime regTime;
    @Column(name = "loginTime")
    private LocalDateTime loginTime;
    @Column(columnDefinition = "BOOLEAN", nullable = false)
    private boolean status;
    @Column(columnDefinition = "VARCHAR(11)", nullable = false)
    private String role;

    public void updateLoginTime() {
        this.loginTime = LocalDateTime.now();
    }

}

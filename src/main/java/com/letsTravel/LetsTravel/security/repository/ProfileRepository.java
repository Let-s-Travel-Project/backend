package com.letsTravel.LetsTravel.security.repository;

import com.letsTravel.LetsTravel.domain.profile.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    @Query("select p from Profile p where p.username = :username")
    Profile findByUsername(@Param("username") String username);

}

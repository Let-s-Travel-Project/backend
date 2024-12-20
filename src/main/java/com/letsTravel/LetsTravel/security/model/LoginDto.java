package com.letsTravel.LetsTravel.security.model;

import com.letsTravel.LetsTravel.domain.profile.entity.UserRole;
import lombok.Data;

@Data
public class LoginDto {
    
    private String username;
    private String password;
    private UserRole role;
    
}

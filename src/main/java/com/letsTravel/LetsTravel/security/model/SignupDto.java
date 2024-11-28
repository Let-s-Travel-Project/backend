package com.letsTravel.LetsTravel.security.model;

import lombok.Data;

import java.util.Date;

@Data
public class SignupDto {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String nickname;
    private Date birth = null;
    private Boolean sex = null;
    private boolean status = true;

}

package com.fackluckincoffee.entity.PersonalInfoPage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String user_id;
    private String username;
    private String password;
    private String email;
    private double balance;
}

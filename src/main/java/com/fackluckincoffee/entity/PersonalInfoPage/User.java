package com.fackluckincoffee.entity.PersonalInfoPage;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "users")
public class User {
    private String user_id;
    private String username;
    private String password;
    private String email;
    private BigDecimal balance;
}

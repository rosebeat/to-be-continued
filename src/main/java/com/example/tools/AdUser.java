package com.example.tools;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: kai·yang
 * @Date: 2024/4/28 10:14
 * @Description:
 */

@Data
@NoArgsConstructor
public class AdUser {

    String name;

    int age;

    public AdUser(String name, int age){
        this.name = name;
        this.age = age;
    }

}

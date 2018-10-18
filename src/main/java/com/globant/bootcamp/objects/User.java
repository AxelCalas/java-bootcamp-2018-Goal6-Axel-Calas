package com.globant.bootcamp.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "Users")
public class User {
    private @Id @GeneratedValue Long user_id;
    private String name;
    private String password;

    public User(String name,String password){
        this.name = name;
        this.password = password;
    }
}


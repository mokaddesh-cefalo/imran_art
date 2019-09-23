package com.shovon.article.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User implements Serializable {

    @Column(unique = true, length = 20, nullable = false, updatable = false)
    @Id
    private  String userName;
    private String password;
    private boolean active;
    private String roles;

    @OneToMany
    private List<Article> articleList;
}

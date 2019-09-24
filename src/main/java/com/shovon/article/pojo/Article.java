package com.shovon.article.pojo;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Article implements Serializable {

    private String title;
    private String body;

    @Column(updatable = false)
    private  String date;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User createdBy;

    @PrePersist
    void beforeAdding(){
        date = new Date().toString();
    }

}

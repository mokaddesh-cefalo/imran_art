package com.shovon.article.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Article implements Serializable {

    private String title;
    private String body;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date date;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @PrePersist
    void beforeAdding(){
        date = new Date();
    }
}

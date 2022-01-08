package com.works.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    @Length(message = "Min:3 Max:40", min = 3, max = 40)
    @NotEmpty(message = "Not Empty Title")
    @Column(unique = true, length = 40)
    private String title;



}

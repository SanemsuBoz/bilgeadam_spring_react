package com.works.useredis;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@RedisHash("categories")
@Data
public class RCategories {

    @Id
    private String id;
    private Integer cid;
    private String title;

}

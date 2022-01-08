package com.works.useredis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableRedisRepositories
public interface RCategoriesRepository extends JpaRepository<RCategories, String> {
}

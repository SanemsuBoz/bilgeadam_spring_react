package com.works.restcontrollers;

import com.works.entities.Categories;
import com.works.enums.REnum;
import com.works.repositories.CategoriesRepository;
import com.works.useredis.RCategories;
import com.works.useredis.RCategoriesRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoriesRestController {

    final CategoriesRepository cRepo;
    final RCategoriesRepository rRepo;
    public CategoriesRestController(CategoriesRepository cRepo, RCategoriesRepository rRepo) {
        this.cRepo = cRepo;
        this.rRepo = rRepo;
    }

    // insert
    @PostMapping("/add")
    public Map<REnum, Object> add(@RequestBody Categories categories ) {
        Map<REnum, Object> hm = new LinkedHashMap<>();

        Categories c = cRepo.save(categories);
        hm.put( REnum.status, true);
        hm.put( REnum.result, c );

        // Redis Insert
        RCategories r = new RCategories();
        r.setCid(c.getCid());
        r.setTitle(c.getTitle());
        r.setId(UUID.randomUUID().toString());
        rRepo.save(r);

        return hm;
    }



}

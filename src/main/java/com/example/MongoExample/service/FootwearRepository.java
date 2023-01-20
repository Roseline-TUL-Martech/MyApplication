package com.example.MongoExample.service;

import com.example.MongoExample.dto.FootwearModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FootwearRepository extends MongoRepository<FootwearModel,Integer> {
    @Query("{name : '?0'}")
    List<FootwearModel> findItemByName(String name);
    @Query("{name : '?0'}")
    List<FootwearModel> getProductDetails();
}

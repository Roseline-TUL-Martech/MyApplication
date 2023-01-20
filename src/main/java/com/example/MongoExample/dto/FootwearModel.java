package com.example.MongoExample.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "footwear")
public class FootwearModel {
    @Id
    private int id;
    private String name;

    private String category;



}

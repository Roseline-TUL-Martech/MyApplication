package com.example.MongoExample.controller;

import com.example.MongoExample.dto.FootwearModel;
import com.example.MongoExample.service.FootwearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/footwear")
public class FootwearController {

    @Autowired
    private FootwearRepository footwearRepository;

    @PostMapping("/addFootwear")
    public String saveFootwear(@RequestBody FootwearModel footwear){
        footwearRepository.save(footwear);
        return "Added Footwear with id : "+footwear.getId();

    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<FootwearModel>> getItemByName(@PathVariable ("productname") @RequestParam("name") String name) {

        try {
            List<FootwearModel> footwear = new ArrayList<>();
            footwearRepository.findItemByName(name).forEach(footwear::add);
            if(footwear.isEmpty()){
                return new ResponseEntity<>((HttpStatus.NO_CONTENT));
            }

            return new ResponseEntity<>(footwear,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllProduct")
    public List<FootwearModel> getProductDetails() {
            return footwearRepository.findAll();
    }

    @GetMapping("/findbyId/{id}")
    public Optional findItemByCategory(@PathVariable int id) {
        return footwearRepository.findById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteItem(@PathVariable int id){
         footwearRepository.deleteById(id);
        return "Item deleted with the id "+id;
    }
}
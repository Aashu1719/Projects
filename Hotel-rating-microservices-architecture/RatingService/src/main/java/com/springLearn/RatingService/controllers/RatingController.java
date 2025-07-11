package com.springLearn.RatingService.controllers;

import com.springLearn.RatingService.entities.Rating;
import com.springLearn.RatingService.services.RatingServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/ratings")
public class RatingController
{
        @Autowired
        private RatingServiceImpl ratingService;

//    create rating
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    //    get all
    @GetMapping()
    public ResponseEntity<List<Rating>> getRatings()
    {
        return ResponseEntity.ok(ratingService.getRatings());
    }

//    get all
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId)
    {
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    //    get all
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId)
    {
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }


}

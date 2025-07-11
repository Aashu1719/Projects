package com.springLearn.RatingService.services;

import com.springLearn.RatingService.entities.Rating;

import java.util.List;


public interface RatingService
{
//    create
Rating create(Rating rating);

//  get all rating
  List<Rating> getRatings();

//    get all by userId
    List<Rating> getRatingByUserId(String userId);

//    get all by hotel
    List<Rating> getRatingByHotelId(String hotelId);

}

package com.springLearn.HotelService.repositories;

import com.springLearn.HotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String>
{
}

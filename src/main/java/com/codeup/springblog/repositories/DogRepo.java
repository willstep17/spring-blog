package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepo extends JpaRepository<Dog, Long> {
}
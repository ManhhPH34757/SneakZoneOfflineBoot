package com.spring.sneakzoneofflineboot.repositories;

import com.spring.sneakzoneofflineboot.entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, String> {
}
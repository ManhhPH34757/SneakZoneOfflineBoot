package com.spring.sneakzoneofflineboot.utils;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UtilityServices <E, T>{
     List<E> getAll();
     E getById(T id);
     E save(E entity);
     E update(E entity, T id);
     void deleteById(T id);
     Boolean findByName(String name);
     E getByName(String name);
}

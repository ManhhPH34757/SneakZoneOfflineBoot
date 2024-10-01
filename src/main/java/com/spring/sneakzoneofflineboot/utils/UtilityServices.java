package com.spring.sneakzoneofflineboot.utils;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UtilityServices <E, T>{
     List<E> getAll();
     E getById(T id);
     E save(E entity);
     void deleteById(T id);
}

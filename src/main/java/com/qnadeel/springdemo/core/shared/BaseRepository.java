package com.qnadeel.springdemo.core.shared;

import com.qnadeel.springdemo.core.shared.exeption.ResourcesNotFoundException;

import java.util.Optional;
import java.util.UUID;

public interface BaseRepository <T>{
    T save(T t);

    void deleteAll();

    Optional<T> findById(UUID id);

    default T getOrThrowByID(UUID id){
        return findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException(id));
    }
}
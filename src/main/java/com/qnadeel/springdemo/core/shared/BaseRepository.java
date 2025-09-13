package com.qnadeel.springdemo.core.shared;

public interface BaseRepository <T>{
    T save(T t);

    void deleteAll();
}
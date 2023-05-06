package com.example.demo.Intergration;

public interface DTOMapper<T, C> {
    public <T> T apply(C item);
}


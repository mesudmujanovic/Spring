package com.example.demo.Intergration;

public interface EntityMaper<T, C ,L> {
    public <T> T apply(C item, L id);
}

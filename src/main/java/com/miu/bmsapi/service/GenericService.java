package com.miu.bmsapi.service;

import com.miu.bmsapi.enums.OperationResult;

import java.util.List;

public interface GenericService<T> {
    T save(T t);

    T update(int id, T t);

    T getById(int id);

    OperationResult delete(int id);

    List<T> getAll();
}

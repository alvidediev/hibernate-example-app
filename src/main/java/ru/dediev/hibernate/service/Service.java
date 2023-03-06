package ru.dediev.hibernate.service;

import java.util.List;

public interface Service<T, ID> {
    T save(T id);

    T getById(ID id);

    List<T> getAll();

    T update(T t, ID id);

    T deleteById(ID id);
}

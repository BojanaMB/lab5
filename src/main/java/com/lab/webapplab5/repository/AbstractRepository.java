/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.repository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author b.radomirovic
 * @param <E>
 */
public interface AbstractRepository<E> {
    E findById(Long id);
    List<E> findAll();
    E save(E e);
    void remove(E e) throws IllegalArgumentException;
}

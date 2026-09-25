package com.example.universitytask.repositories;

import com.example.universitytask.models.entities.Student;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

interface DbService {

    Optional<Student> findByEmail(final String email);

    Optional<Student> findById(final UUID id);

    Collection<Student> findAll();

    void saveOrUpdate(final Student student);

    void delete(final UUID id);

    void clear();
}

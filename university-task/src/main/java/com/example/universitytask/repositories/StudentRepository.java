package com.example.universitytask.repositories;

import com.example.universitytask.errors.exceptions.RegisterException;
import com.example.universitytask.models.entities.Student;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

 public interface StudentRepository {
     Optional<Student> findByEmail(final String email) throws RegisterException;

     Optional<Student> findById(final UUID id) throws RegisterException ;

     Collection<Student> findAllSortedByAge();

     Collection<Student> findAllSucceeded();

     void save(final Student student);

     void delete(final UUID id);

     void deleteAll();

     void update(final Student student);
}

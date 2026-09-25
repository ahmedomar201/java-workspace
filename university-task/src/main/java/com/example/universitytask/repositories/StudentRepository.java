package com.example.universitytask.repositories;

import com.example.universitytask.errors.exceptions.RegisterException;
import com.example.universitytask.models.entities.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class StudentRepository {

    private final DbService dbService;

    public Optional<Student> findByEmail(final String email)
            throws RegisterException {
        return dbService.findByEmail(email);
    }

    public Optional<Student> findById(final UUID id)
            throws RegisterException {
        return dbService.findById(id);
    }

    public Collection<Student> findAllSortedByAge() {
        return dbService.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Student::getAge))
                .toList();
    }

    public Collection<Student> findAllSucceeded() {
        return dbService.findAll()
                .stream()
                .filter(Student::isPassedExam)
                .toList();
    }

    public void save(final Student student) {
        dbService.saveOrUpdate(student);
    }

    public void delete(final UUID id) {
        dbService.delete(id);
    }

    public void deleteAll() {
        dbService.clear();
    }

    public void update(final Student student) {
        dbService.saveOrUpdate(student);
    }
}

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
public class StudentRepositoryImp implements StudentRepository {

    private final DbService dbService;

    @Override
    public Optional<Student> findByEmail(final String email)
            throws RegisterException {
        return dbService.findByEmail(email);
    }
    @Override
    public Optional<Student> findById(final UUID id)
            throws RegisterException {
        return dbService.findById(id);
    }
    @Override
    public Collection<Student> findAllSortedByAge() {
        return dbService.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Student::getAge))
                .toList();
    }
    @Override
    public Collection<Student> findAllSucceeded() {
        return dbService.findAll()
                .stream()
                .filter(Student::isPassedExam)
                .toList();
    }
    @Override
    public void save(final Student student) {
        dbService.saveOrUpdate(student);
    }
    @Override
    public void delete(final UUID id) {
        dbService.delete(id);
    }
    @Override
    public void deleteAll() {
        dbService.clear();
    }
    @Override
    public void update(final Student student) {
        dbService.saveOrUpdate(student);
    }
}

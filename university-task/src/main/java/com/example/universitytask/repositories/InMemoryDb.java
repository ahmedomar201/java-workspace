package com.example.universitytask.repositories;

import com.example.universitytask.errors.exceptions.RegisterException;
import com.example.universitytask.models.entities.Student;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryDb implements DbService {

    //ConcurrentHashMap استخدمتها عشان لو 2 ريكوست جاييين في نفس الوقت thread الاول ميقطعش thread التاني
    public final Map<UUID, Student> studentDb = new ConcurrentHashMap<>();

    @Override
    public Optional<Student> findByEmail(final String email)
            throws RegisterException {
        return studentDb.values().stream().filter(
                student -> student.getEmail().equals(email)
        ).findFirst();
    }

    @Override
    public Optional<Student> findById(final UUID id)
            throws RegisterException {
        return Optional.ofNullable(studentDb.get(id));
    }

    @Override
    public Collection<Student> findAll() {
        return studentDb.values();
    }

    @Override
    public void saveOrUpdate(final Student student) {
        studentDb.put(student.getId(), student);
    }

    @Override
    public void delete(final UUID id) {
        studentDb.remove(id);
    }

    @Override
    public void clear() {
        studentDb.clear();
    }

}

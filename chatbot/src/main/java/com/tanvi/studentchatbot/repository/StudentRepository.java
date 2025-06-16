package com.tanvi.studentchatbot.repository;

import com.tanvi.studentchatbot.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    // Custom methods can be added here if needed
}

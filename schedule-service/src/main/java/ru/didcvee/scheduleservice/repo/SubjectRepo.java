package ru.didcvee.scheduleservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.didcvee.scheduleservice.entity.Subject;

import java.util.Optional;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Integer> {
    Optional<Subject> findBySubjectName(String name);
}

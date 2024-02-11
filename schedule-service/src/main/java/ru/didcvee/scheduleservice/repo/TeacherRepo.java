package ru.didcvee.scheduleservice.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.didcvee.scheduleservice.entity.Teacher;

import java.util.Optional;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Integer> {
    Page<Teacher> findAll(Pageable pageable);
    Optional<Teacher> findById(int id);
}

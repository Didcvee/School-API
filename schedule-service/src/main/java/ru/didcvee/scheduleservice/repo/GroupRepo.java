package ru.didcvee.scheduleservice.repo;

import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;
import ru.didcvee.scheduleservice.entity.Group;

import java.util.List;

@Repository
public interface GroupRepo extends JpaRepository<Group, Integer> {

    @Query(value = "SELECT * FROM schedule.public.group_ OFFSET :page * :page_size LIMIT :page_size",
            nativeQuery = true)
    List<Group> findAll(int page, int page_size);
}

package ru.didcvee.scheduleservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.didcvee.scheduleservice.entity.Teacher;
import ru.didcvee.scheduleservice.repo.TeacherRepo;

import java.util.Optional;

@Service
public class TeacherService {
    private final TeacherRepo teacherRepo;

    @Autowired
    public TeacherService(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }
    @Transactional(readOnly = true)
    public Page<Teacher> findAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return teacherRepo.findAll(pageable);
    }
    @Transactional(readOnly = true)
    public Teacher getOne(int id){
        Optional<Teacher> teacher = teacherRepo.findById(id);
        if(teacher.isEmpty()){
            throw new RuntimeException();
        }
        return teacher.get();
    }
    @Transactional
    public Teacher saveTeacher(Teacher teacher){
        Teacher savedTeacher = teacherRepo.save(teacher);
        return savedTeacher;
    }

}

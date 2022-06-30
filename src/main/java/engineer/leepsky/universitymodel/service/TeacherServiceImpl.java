package engineer.leepsky.universitymodel.service;

import engineer.leepsky.universitymodel.model.Teacher;
import engineer.leepsky.universitymodel.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public boolean create(Teacher teacher) {
        if (!teacherRepository.existsById(teacher.getId())) {
            teacherRepository.save(teacher);
            return true;
        }
        return false;
    }

    @Override
    public List<Teacher> readAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher read(Integer id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.orElse(null);
    }

    @Override
    public boolean update(Integer id, Teacher teacher) {
        if (teacherRepository.existsById(id)) {
            teacher.setId(id);
            teacherRepository.save(teacher);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        if (teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
            return true;
        }
        return false;
    }

}


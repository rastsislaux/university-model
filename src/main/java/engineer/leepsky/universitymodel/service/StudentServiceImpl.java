package engineer.leepsky.universitymodel.service;

import engineer.leepsky.universitymodel.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Map<String, Student> STUDENT_MAP = new HashMap<>();

    @Override
    public boolean create(Student student) {
        if (!STUDENT_MAP.containsKey(student.getId())) {
            STUDENT_MAP.put(student.getId(), student);
            return true;
        }
        return false;
    }

    @Override
    public List<Student> readAll() {
        return new ArrayList<>(STUDENT_MAP.values());
    }

    @Override
    public Student read(String id) {
        return STUDENT_MAP.get(id);
    }

    @Override
    public boolean update(String id, Student student) {
        if (STUDENT_MAP.containsKey(id)) {
            STUDENT_MAP.put(id, student);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        return STUDENT_MAP.remove(id) != null;
    }

}

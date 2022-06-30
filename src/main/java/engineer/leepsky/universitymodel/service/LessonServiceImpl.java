package engineer.leepsky.universitymodel.service;

import engineer.leepsky.universitymodel.model.Lesson;
import engineer.leepsky.universitymodel.model.Lesson;
import engineer.leepsky.universitymodel.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public boolean create(Lesson lesson) {
        if (!lessonRepository.existsById(lesson.getId())) {
            lessonRepository.save(lesson);
            return true;
        }
        return false;
    }

    @Override
    public List<Lesson> readAll() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson read(Integer id) {
        Optional<Lesson> lesson = lessonRepository.findById(id);
        return lesson.orElse(null);
    }

    @Override
    public boolean update(Integer id, Lesson lesson) {
        if (lessonRepository.existsById(id)) {
            lesson.setId(id);
            lessonRepository.save(lesson);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        if (lessonRepository.existsById(id)) {
            lessonRepository.deleteById(id);
            return true;
        }
        return false;
    }

}


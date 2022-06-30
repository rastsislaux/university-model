package engineer.leepsky.universitymodel.service;

import engineer.leepsky.universitymodel.model.Subject;
import engineer.leepsky.universitymodel.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public boolean create(Subject subject) {
        if (!subjectRepository.existsById(subject.getId())) {
            subjectRepository.save(subject);
            return true;
        }
        return false;
    }

    @Override
    public List<Subject> readAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject read(Integer id) {
        Optional<Subject> subject = subjectRepository.findById(id);
        return subject.orElse(null);
    }

    @Override
    public boolean update(Integer id, Subject subject) {
        if (subjectRepository.existsById(id)) {
            subject.setId(id);
            subjectRepository.save(subject);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        if (subjectRepository.existsById(id)) {
            subjectRepository.deleteById(id);
            return true;
        }
        return false;
    }

}


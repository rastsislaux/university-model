package engineer.leepsky.universitymodel.service;

import engineer.leepsky.universitymodel.model.Group;
import engineer.leepsky.universitymodel.model.Lesson;
import engineer.leepsky.universitymodel.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public boolean create(Group group) {
        if (!groupRepository.existsById(group.getId())) {
            groupRepository.save(group);
            return true;
        }
        return false;
    }

    @Override
    public List<Group> readAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group read(Integer id) {
        Optional<Group> group = groupRepository.findById(id);
        return group.orElse(null);
    }

    @Override
    public boolean update(Integer id, Group group) {
        if (groupRepository.existsById(id)) {
            group.setId(id);
            groupRepository.save(group);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        if (groupRepository.existsById(id)) {
            groupRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Lesson> getLessons(Integer id) {
        return groupRepository.getGroupLessons(id);
    }

    @Override
    public List<Lesson> getLessonsOnDate(Integer id, Date date) {
        return groupRepository.getGroupLessonsByDate(id, date);
    }
}

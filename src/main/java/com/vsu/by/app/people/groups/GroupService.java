package com.vsu.by.app.people.groups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Transactional(readOnly = true)
    public Optional<Group> getGroup(Long id) {
        return this.groupRepository.findById(id);
    }

    @Transactional
    public Group saveGroup(Group group) {
        return this.groupRepository.save(group);
    }

    @Transactional
    public Group updateGroup(Group group) {
        return this.groupRepository.save(group);
    }

    @Transactional
    public void deleteGroup(Long id) {
        this.groupRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Group> findAll() {
        return this.groupRepository.findAll();
    }
}

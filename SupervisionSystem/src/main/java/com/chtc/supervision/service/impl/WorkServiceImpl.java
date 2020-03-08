package com.chtc.supervision.service.impl;

import com.chtc.supervision.entity.Work;
import com.chtc.supervision.repository.WorkRepository;
import com.chtc.supervision.service.IWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements IWorkService {
    @Autowired
    WorkRepository workRepository;

    @Override
    public List<Work> findAllWork() {
        return workRepository.findAll();
    }

    @Override
    public Work findWorkByNameAndSubject(String studentName, String subjects) {
        return workRepository.findWorkByNameAndSubject(studentName,subjects);
    }

    @Override
    public String findIdByUsername(String username) {
        return workRepository.findIdByUsername(username);
    }

    @Override
    public List<Work> findWorkById(String id) {
        return workRepository.findWorkById(id);
    }

    @Override
    public void updateWork(String studentName, String subjects, String w_content) {
        workRepository.updateWork(studentName,subjects,w_content);
    }

    @Override
    public void deleteWork(String studentName, String subjects) {
        workRepository.deleteWork(studentName,subjects);
    }

    @Override
    public void addWork(String user_id, String studentName, String subjects, String w_content) {
        workRepository.addWork(user_id,studentName,subjects,w_content);
    }

    @Override
    public String findStudentNameByUsername(String username) {
        return workRepository.findStudentNameByUsername(username);
    }


}

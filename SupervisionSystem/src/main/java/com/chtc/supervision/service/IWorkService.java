package com.chtc.supervision.service;

import com.chtc.supervision.entity.Work;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IWorkService {
    List<Work> findAllWork();

    Work findWorkByNameAndSubject(String studentName,String subjects);

    String findIdByUsername(String username);

    List<Work> findWorkById(String id);

    void updateWork(String studentName,String subjects,String w_content);

    void deleteWork(String studentName,String subjects);

    void addWork(String user_id,String studentName,String subjects,String w_content);

    String findStudentNameByUsername(String username);
}

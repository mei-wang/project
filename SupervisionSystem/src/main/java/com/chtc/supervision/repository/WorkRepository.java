package com.chtc.supervision.repository;

import com.chtc.supervision.entity.CourseComment;
import com.chtc.supervision.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface WorkRepository extends JpaRepository<Work,String> {

    @Query(value = "select * from work ", nativeQuery = true)
    List<Work> findAll();

    @Query(value = "select * from work where studentName =:studentName and subjects =:subjects ",nativeQuery = true)
    Work findWorkByNameAndSubject(@Param("studentName") String studentName,@Param("subjects")String subjects);

    @Query(value = "select id from user where username =:username",nativeQuery = true)
    String findIdByUsername(@Param("username") String username);

    @Query(value = "select * from work where user_id =:id",nativeQuery = true)
    List<Work> findWorkById(@Param("id") String id);

    @Transactional
    @Modifying
    @Query(value = "update work SET w_content=:w_content where studentName=:studentName and subjects=:subjects",nativeQuery = true)
    void updateWork(@Param("studentName") String studentName,@Param("subjects")String subjects,@Param("w_content")String w_content);

    @Transactional
    @Modifying
    @Query(value = "DELETE from work where studentName = :studentName and subjects=:subjects ", nativeQuery = true)
    void deleteWork(@Param("studentName") String studentName,@Param("subjects")String subjects);

    @Query(value = "select nickName from user where username =:username",nativeQuery = true)
    String findStudentNameByUsername(@Param("username") String username);

    @Transactional
    @Modifying
    @Query(value = "insert into work(id,user_id,studentName,subjects,w_content) values(null,:user_id,:studentName,:subjects,:w_content)",nativeQuery = true)
    void addWork(@Param("user_id") String user_id,@Param("studentName") String studentName,@Param("subjects")String subjects,@Param("w_content")String w_content);
}

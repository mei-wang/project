package com.chtc.supervision.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "work")
public class Work implements Serializable {
    @Id
    private Integer id;
    private String user_id;
    private String studentName;
    private String subjects;
    private String w_content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getW_content() {
        return w_content;
    }

    public void setW_content(String w_content) {
        this.w_content = w_content;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", user_id='" + user_id + '\'' +
                ", studentName='" + studentName + '\'' +
                ", subjects='" + subjects + '\'' +
                ", w_content='" + w_content + '\'' +
                '}';
    }
}

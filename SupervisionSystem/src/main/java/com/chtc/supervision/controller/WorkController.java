package com.chtc.supervision.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chtc.supervision.entity.Msg;
import com.chtc.supervision.entity.Work;
import com.chtc.supervision.service.IWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.plugin.liveconnect.SecurityContextHelper;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/task")
public class WorkController {
    @Autowired
    private IWorkService iWorkService;

    @RequestMapping(value = "/findWork")
    @ResponseBody
    public List<Work> findWork(){
        List<Work> work = iWorkService.findAllWork();
        return work;
    }

    @RequestMapping(value = "/findWorkByNameAndSubject")
    @ResponseBody
    public Work findWorkByNameAndSubject(String studentName,String subjects){
        Work work = iWorkService.findWorkByNameAndSubject(studentName, subjects);
        return work;
    }

    @RequestMapping(value = "/findMyWork")
    @ResponseBody
    public List<Work> findWorkByNameAndSubject(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String id = iWorkService.findIdByUsername(username);
        List<Work> work = iWorkService.findWorkById(id);
        return work;
    }

    @RequestMapping(value = "/updateWork")
    @ResponseBody
    public String updateWork(String studentName,String subjects,String w_content){
        iWorkService.updateWork(studentName,subjects,w_content);
        return "mywork";
    }

    @RequestMapping(value = "/deleteWork")
    @ResponseBody
    public String deleteWork(String studentName,String subjects){
        iWorkService.deleteWork(studentName,subjects);
        return "mywork";
    }

    @RequestMapping(value = "/addWork")
    @ResponseBody
    public Msg addWork(String subjects, String w_content){
        Msg msg = new Msg();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String studentName = iWorkService.findStudentNameByUsername(username);
        System.out.println(studentName);

        String user_id = iWorkService.findIdByUsername(username);
        Work work = iWorkService.findWorkByNameAndSubject(studentName, subjects);

        System.out.println(user_id+studentName+subjects+w_content);

        if(work==null){
            iWorkService.addWork(user_id,studentName,subjects,w_content);
            msg.setSuccess("成功");
        }else {
            msg.setFailure("失败");
        }
        return msg;
    }

}

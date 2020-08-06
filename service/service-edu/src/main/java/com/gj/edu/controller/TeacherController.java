package com.gj.edu.controller;


import com.gj.edu.entity.Teacher;
import com.gj.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author GuoJun
 * @since 2020-08-05
 */
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 查询讲师表所有数据
     */
    @GetMapping("/listAll")
    public List<Teacher> listAll(){
        List<Teacher> list = teacherService.list(null);
        return list;
    }

    /**
     * 讲师逻辑删除
     */
    @DeleteMapping("{id}")
    public Boolean removeById(@PathVariable String id){
        return teacherService.removeById(id);
    }
}


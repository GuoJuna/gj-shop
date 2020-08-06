package com.gj.edu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gj.commonutils.R;
import com.gj.edu.entity.Teacher;
import com.gj.edu.query.TeacherQuery;
import com.gj.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(description="讲师管理")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @ApiOperation(value = "分页讲师列表")
    @GetMapping("{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page", value = "当前页面",required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "teacherQuery", value = "查询对象", required = true)
            TeacherQuery teacherQuery){
        Page<Teacher> pageParam = new Page<>(page, limit);
        teacherService.pageQuery(pageParam,teacherQuery);
        List<Teacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return R.ok().data("total", total).data("rows",records);
    }

    /**
     * 查询讲师表所有数据
     */
    @ApiOperation(value = "所有讲师列表")
    @GetMapping("/listAll")
    public R listAll(){
        List<Teacher> list = teacherService.list(null);
        return R.ok().data("items",list);
    }

    /**
     * 讲师逻辑删除
     * @return
     */
    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping("{id}")
    public R removeById(@PathVariable String id){
        teacherService.removeById(id);
        return R.ok();
    }

    /**
     * 新增讲师
     */
    @ApiOperation(value = "新增讲师")
    @PostMapping
    public R save(
            @ApiParam(name = "teacher", value = "将是对象", required = true)
            @RequestBody Teacher teacher){
        teacherService.save(teacher);
        return R.ok();
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public R getById(
            @ApiParam(name = "id", value = "讲师", required = true)
            @PathVariable String id){
        Teacher teacher = teacherService.getById(id);
        return R.ok().data("item",teacher);
    }

    /**
     * 根据ID修改
     */
    @ApiOperation(value = "根据ID修改讲师")
    @PutMapping("{id}")
    public R updateById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id,
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher){
        teacher.setId(id);
        teacherService.updateById(teacher);
        return R.ok();
    }
}


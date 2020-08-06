package com.gj.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gj.edu.entity.Teacher;
import com.gj.edu.mapper.TeacherMapper;
import com.gj.edu.query.TeacherQuery;
import com.gj.edu.service.TeacherService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author GuoJun
 * @since 2020-08-05
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public void pageQuery(Page<Teacher> pageParam, TeacherQuery teacherQuery) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("sort");
        if(teacherQuery == null){
            baseMapper.selectPage(pageParam, queryWrapper);
            return;
        }
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        if(StringUtils.isNotEmpty(name)){
            queryWrapper.like("name",name);
        }
        if(ObjectUtils.isNotEmpty(level)){
            queryWrapper.eq("level", level);
        }
        if(ObjectUtils.isNotEmpty(begin)){
            queryWrapper.ge("gmt_create", begin);
        }
        if(ObjectUtils.isNotEmpty(end)){
            queryWrapper.le("gmt_create", end);
        }
        baseMapper.selectPage(pageParam, queryWrapper);
    }
}

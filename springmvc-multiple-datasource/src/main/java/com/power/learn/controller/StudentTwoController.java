package com.power.learn.controller;

import com.boco.common.model.CommonResult;
import com.boco.common.util.RandomUtil;
import com.power.learn.model.Student;
import com.power.learn.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("studentTwo")
public class StudentTwoController {

    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(StudentTwoController.class);

    @Resource
    private StudentService studentTwoService;

    @ResponseBody
    @PostMapping(value = "/add")
    public CommonResult save(Student entity) {
        entity.setName(RandomUtil.randomString(6));
        entity.setAddress(RandomUtil.randomString(8));
        entity.setAge(RandomUtil.randomInt(100));
        return studentTwoService.save(entity);
    }

    @ResponseBody
    @PostMapping(value = "/update")
    public CommonResult update(Student entity) {
        return studentTwoService.update(entity);
    }

    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public CommonResult delete(@PathVariable int id) {
        return studentTwoService.delete(id);
    }

    @ResponseBody
    @GetMapping(value = "/query/{id}")
    public CommonResult queryById(@PathVariable int id) {
        return studentTwoService.queryById(id);
    }

    @ResponseBody
    @GetMapping(value = "/page/{offset}/{limit}")
    public PageInfo queryPage(@PathVariable int offset, @PathVariable int limit) {
        return studentTwoService.queryPage(offset,limit);
    }


}

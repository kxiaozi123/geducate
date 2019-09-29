package com.imooc.gulixueyuan.edu.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imooc.gulixueyuan.common.entity.PageResult;
import com.imooc.gulixueyuan.common.entity.R;
import com.imooc.gulixueyuan.edu.entity.Teacher;
import com.imooc.gulixueyuan.edu.entity.query.QueryTeacher;
import com.imooc.gulixueyuan.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("讲师管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/admin/edu/teacher")
public class AdminTeacherController {
    @Autowired
    private TeacherService teacherService;

    @ApiOperation(value = "根据id删除讲师")
    @DeleteMapping(value = "{teacherId}")
    public R deleteById(
            @ApiParam(name = "teacherId", value = "讲师ID", required = true)
            @PathVariable Long teacherId){

        teacherService.removeById(teacherId);
        return R.ok();
    }

    @ApiModelProperty(value = "分页查询列表")
    @PostMapping(value = "{page}/{limit}")
    public R pageQuery(
            @ApiParam(name = "page", value = "页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "queryMap", value = "查询条件", required = false)
            @RequestBody QueryTeacher searchObj){


        Page<Teacher> teacherPage = new Page<>(page, limit);
        teacherService.pageQuery(teacherPage, searchObj);
        List<Teacher> records = teacherPage.getRecords();
        long total = teacherPage.getTotal();
        PageResult<Teacher> pageResult = new PageResult<>(total, records);

        return R.ok().data(pageResult);
    }


    @ApiOperation(value = "根据id查询讲师")
    @GetMapping(value = "{teacherId}")
    public R getById(
            @ApiParam(name = "teacherId", value = "讲师ID", required = true)
            @PathVariable Long teacherId){

        Teacher teacher = teacherService.getById(teacherId);
        return R.ok().data(teacher);
    }

    @ApiOperation(value = "新增讲师")
    @PostMapping()
    public R save(
            @ApiParam(name = "teacher", value = "讲师", required = true)
            @RequestBody Teacher teacher){

        teacherService.save(teacher);
        return R.ok();
    }

    @ApiOperation(value = "修改讲师")
    @PutMapping(value = "{teacherId}")
    public R updateById(

            @ApiParam(name = "teacherId", value = "讲师ID", required = true)
            @PathVariable Long teacherId,

            @ApiParam(name = "teacher", value = "讲师", required = true)
            @RequestBody Teacher teacher){

        teacher.setTeacherId(teacherId);
        teacherService.updateById(teacher);
        return R.ok();
    }

}

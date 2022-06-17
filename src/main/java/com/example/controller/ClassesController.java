package com.example.controller;

import com.example.entity.Classes;
import com.example.service.ClassesService;
import com.example.tools.BaseController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.alibaba.fastjson.JSONArray;
import javax.annotation.Resource;

/**
 * (Classes)表控制层
 *
 * @author makejava
 * @since 2022-06-15 09:12:56
 */
@RestController
@RequestMapping("classes")
public class ClassesController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private ClassesService classesService;

    /**
     * 分页查询
     *
     * @param classes 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Classes>> queryByPage(Classes classes, PageRequest pageRequest) {
        return ResponseEntity.ok(this.classesService.queryByPage(classes, pageRequest));
    }
    
    
     @PostMapping("/getall")
    public String queryall(Classes classes, @RequestParam("page") int offset, @RequestParam("pageSize")int pageSize){
        List<Classes> Classess = this.classesService.queryAllByLimits(classes,offset,pageSize);
        long counts = classesService.count(classes);
        JSONArray jsonArray=new JSONArray();
        jsonArray.add(counts);
        jsonArray.add(Classess);
        return RespInfo(1,"查询信息",jsonArray);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Classes> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.classesService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param classes 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Classes> add(Classes classes) {
        System.out.println(classes);
        return ResponseEntity.ok(this.classesService.insert(classes));
    }

    /**
     * 编辑数据
     *
     * @param classes 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public ResponseEntity<Classes> edit(Classes classes) {
        return ResponseEntity.ok(this.classesService.update(classes));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/del")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.classesService.deleteById(id));
    }

}


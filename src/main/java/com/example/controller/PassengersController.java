package com.example.controller;

import com.example.entity.Passengers;
import com.example.service.PassengersService;
import com.example.tools.BaseController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.alibaba.fastjson.JSONArray;
import javax.annotation.Resource;

/**
 * (Passengers)表控制层
 *
 * @author makejava
 * @since 2022-06-15 09:12:56
 */
@RestController
@RequestMapping("passengers")
public class PassengersController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private PassengersService passengersService;

    /**
     * 分页查询
     *
     * @param passengers 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Passengers>> queryByPage(Passengers passengers, PageRequest pageRequest) {
        return ResponseEntity.ok(this.passengersService.queryByPage(passengers, pageRequest));
    }
    
    
     @PostMapping("/getall")
    public String queryall(Passengers passengers, @RequestParam("page") int offset, @RequestParam("pageSize")int pageSize){
        List<Passengers> Passengerss = this.passengersService.queryAllByLimits(passengers,offset,pageSize);
        long counts = passengersService.count(passengers);
        JSONArray jsonArray=new JSONArray();
        jsonArray.add(counts);
        jsonArray.add(Passengerss);
        return RespInfo(1,"查询信息",jsonArray);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Passengers> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.passengersService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param passengers 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Passengers> add(Passengers passengers) {
        return ResponseEntity.ok(this.passengersService.insert(passengers));
    }

    /**
     * 编辑数据
     *
     * @param passengers 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public ResponseEntity<Passengers> edit(Passengers passengers) {
        return ResponseEntity.ok(this.passengersService.update(passengers));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/del")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.passengersService.deleteById(id));
    }

}


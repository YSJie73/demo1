package com.example.controller;

import com.example.entity.Flight;
import com.example.service.FlightService;
import com.example.tools.BaseController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.alibaba.fastjson.JSONArray;
import javax.annotation.Resource;

/**
 * (Flight)表控制层
 *
 * @author makejava
 * @since 2022-06-15 09:12:56
 */
@RestController
@RequestMapping("flight")
public class FlightController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private FlightService flightService;

    /**
     * 分页查询
     *
     * @param flight 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Flight>> queryByPage(Flight flight, PageRequest pageRequest) {
        return ResponseEntity.ok(this.flightService.queryByPage(flight, pageRequest));
    }
    
    
     @PostMapping("/getall")
    public String queryall(Flight flight, @RequestParam("page") int offset, @RequestParam("pageSize")int pageSize){
        List<Flight> Flights = this.flightService.queryAllByLimits(flight,offset,pageSize);
        long counts = flightService.count(flight);
        JSONArray jsonArray=new JSONArray();
        jsonArray.add(counts);
        jsonArray.add(Flights);
        return RespInfo(1,"查询信息",jsonArray);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Flight> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.flightService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param flight 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Flight> add(Flight flight) {
        return ResponseEntity.ok(this.flightService.insert(flight));
    }

    /**
     * 编辑数据
     *
     * @param flight 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public ResponseEntity<Flight> edit(Flight flight) {
        return ResponseEntity.ok(this.flightService.update(flight));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/del")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.flightService.deleteById(id));
    }

}


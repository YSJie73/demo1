package com.example.controller;

import com.example.entity.Users;
import com.example.service.UsersService;
import com.example.tools.BaseController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.alibaba.fastjson.JSONArray;
import javax.annotation.Resource;

/**
 * (Users)表控制层
 *
 * @author makejava
 * @since 2022-06-15 09:12:56
 */
@RestController
@RequestMapping("users")
public class UsersController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private UsersService usersService;

    /**
     * 分页查询
     *
     * @param users 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Users>> queryByPage(Users users, PageRequest pageRequest) {
        return ResponseEntity.ok(this.usersService.queryByPage(users, pageRequest));
    }
    
    
     @PostMapping("/getall")
    public String queryall(Users users, @RequestParam("page") int offset, @RequestParam("pageSize")int pageSize){
        List<Users> Userss = this.usersService.queryAllByLimits(users,offset,pageSize);
        long counts = usersService.count(users);
        JSONArray jsonArray=new JSONArray();
        jsonArray.add(counts);
        jsonArray.add(Userss);
        return RespInfo(1,"查询信息",jsonArray);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Users> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.usersService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param users 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Users> add(Users users) {
        return ResponseEntity.ok(this.usersService.insert(users));
    }

    /**
     * 编辑数据
     *
     * @param users 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public ResponseEntity<Users> edit(Users users) {
        return ResponseEntity.ok(this.usersService.update(users));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/del")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.usersService.deleteById(id));
    }

    @PostMapping("/login")
    public String login(Users users){
        Users login=this.usersService.login(users);
        return RespInfo(1,"登录信息",login);
    }

}


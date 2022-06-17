package com.example.service;

import com.example.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;
/**
 * (Users)表服务接口
 *
 * @author makejava
 * @since 2022-06-15 09:12:57
 */
public interface UsersService {

    /**
     * 通过ID查询单条数据
     *
     * @param account 主键
     * @return 实例对象
     */
    Users queryById(String account);

    /**
     * 分页查询
     *
     * @param users 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Users> queryByPage(Users users, PageRequest pageRequest);

 List<Users> queryAllByLimits(Users users, int offset,int pageSize);
    
    long count(Users users);
    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    Users insert(Users users);

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    Users update(Users users);

    /**
     * 通过主键删除数据
     *
     * @param account 主键
     * @return 是否成功
     */
    boolean deleteById(String account);

    Users login(Users users);


}

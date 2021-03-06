package com.example.service.impl;

import com.example.entity.Users;
import com.example.dao.UsersDao;
import com.example.service.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import javax.annotation.Resource;

/**
 * (Users)表服务实现类
 *
 * @author makejava
 * @since 2022-06-15 10:18:54
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersDao usersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param account 主键
     * @return 实例对象
     */
    @Override
    public Users queryById(String account) {
        return this.usersDao.queryById(account);
    }

    /**
     * 分页查询
     *
     * @param users 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Users> queryByPage(Users users, PageRequest pageRequest) {
        long total = this.usersDao.count(users);
        return new PageImpl<>(this.usersDao.queryAllByLimit(users, pageRequest), pageRequest, total);
    }
    
     @Override
    public List<Users> queryAllByLimits(Users users, int offset, int pageSize) {
        return this.usersDao.queryAllByLimits(users,(offset-1)*pageSize,pageSize);
    }
    
     @Override
    public long count(Users users) {
        long total = this.usersDao.count(users);
        return total;
    }

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public Users insert(Users users) {
        this.usersDao.insert(users);
        return users;
    }

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public Users update(Users users) {
        this.usersDao.update(users);
        return this.queryById(users.getAccount());
    }

    /**
     * 通过主键删除数据
     *
     * @param account 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String account) {
        return this.usersDao.deleteById(account) > 0;
    }

    @Override
    public Users login(Users users) {
        return this.usersDao.login(users);
    }



}

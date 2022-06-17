package com.example.service.impl;

import com.example.entity.Passengers;
import com.example.dao.PassengersDao;
import com.example.service.PassengersService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import javax.annotation.Resource;

/**
 * (Passengers)表服务实现类
 *
 * @author makejava
 * @since 2022-06-15 10:18:54
 */
@Service("passengersService")
public class PassengersServiceImpl implements PassengersService {
    @Resource
    private PassengersDao passengersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param ordernumber 主键
     * @return 实例对象
     */
    @Override
    public Passengers queryById(Integer ordernumber) {
        return this.passengersDao.queryById(ordernumber);
    }

    /**
     * 分页查询
     *
     * @param passengers 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Passengers> queryByPage(Passengers passengers, PageRequest pageRequest) {
        long total = this.passengersDao.count(passengers);
        return new PageImpl<>(this.passengersDao.queryAllByLimit(passengers, pageRequest), pageRequest, total);
    }
    
     @Override
    public List<Passengers> queryAllByLimits(Passengers passengers, int offset, int pageSize) {
        return this.passengersDao.queryAllByLimits(passengers,(offset-1)*pageSize,pageSize);
    }
    
     @Override
    public long count(Passengers passengers) {
        long total = this.passengersDao.count(passengers);
        return total;
    }

    /**
     * 新增数据
     *
     * @param passengers 实例对象
     * @return 实例对象
     */
    @Override
    public Passengers insert(Passengers passengers) {
        this.passengersDao.insert(passengers);
        return passengers;
    }

    /**
     * 修改数据
     *
     * @param passengers 实例对象
     * @return 实例对象
     */
    @Override
    public Passengers update(Passengers passengers) {
        this.passengersDao.update(passengers);
        return this.queryById(passengers.getOrdernumber());
    }

    /**
     * 通过主键删除数据
     *
     * @param ordernumber 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer ordernumber) {
        return this.passengersDao.deleteById(ordernumber) > 0;
    }
}

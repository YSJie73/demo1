package com.example.service.impl;

import com.example.entity.Flight;
import com.example.dao.FlightDao;
import com.example.service.FlightService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import javax.annotation.Resource;

/**
 * (Flight)表服务实现类
 *
 * @author makejava
 * @since 2022-06-15 10:18:54
 */
@Service("flightService")
public class FlightServiceImpl implements FlightService {
    @Resource
    private FlightDao flightDao;

    /**
     * 通过ID查询单条数据
     *
     * @param flightnumber 主键
     * @return 实例对象
     */
    @Override
    public Flight queryById(String flightnumber) {
        return this.flightDao.queryById(flightnumber);
    }

    /**
     * 分页查询
     *
     * @param flight 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Flight> queryByPage(Flight flight, PageRequest pageRequest) {
        long total = this.flightDao.count(flight);
        return new PageImpl<>(this.flightDao.queryAllByLimit(flight, pageRequest), pageRequest, total);
    }
    
     @Override
    public List<Flight> queryAllByLimits(Flight flight, int offset, int pageSize) {
        return this.flightDao.queryAllByLimits(flight,(offset-1)*pageSize,pageSize);
    }
    
     @Override
    public long count(Flight flight) {
        long total = this.flightDao.count(flight);
        return total;
    }

    /**
     * 新增数据
     *
     * @param flight 实例对象
     * @return 实例对象
     */
    @Override
    public Flight insert(Flight flight) {
        this.flightDao.insert(flight);
        return flight;
    }

    /**
     * 修改数据
     *
     * @param flight 实例对象
     * @return 实例对象
     */
    @Override
    public Flight update(Flight flight) {
        this.flightDao.update(flight);
        return this.queryById(flight.getFlightnumber());
    }

    /**
     * 通过主键删除数据
     *
     * @param flightnumber 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String flightnumber) {
        return this.flightDao.deleteById(flightnumber) > 0;
    }
}

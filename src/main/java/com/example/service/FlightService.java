package com.example.service;

import com.example.entity.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;
/**
 * (Flight)表服务接口
 *
 * @author makejava
 * @since 2022-06-15 09:12:56
 */
public interface FlightService {

    /**
     * 通过ID查询单条数据
     *
     * @param flightnumber 主键
     * @return 实例对象
     */
    Flight queryById(String flightnumber);

    /**
     * 分页查询
     *
     * @param flight 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Flight> queryByPage(Flight flight, PageRequest pageRequest);

 List<Flight> queryAllByLimits(Flight flight, int offset,int pageSize);
    
    long count(Flight flight);
    /**
     * 新增数据
     *
     * @param flight 实例对象
     * @return 实例对象
     */
    Flight insert(Flight flight);

    /**
     * 修改数据
     *
     * @param flight 实例对象
     * @return 实例对象
     */
    Flight update(Flight flight);

    /**
     * 通过主键删除数据
     *
     * @param flightnumber 主键
     * @return 是否成功
     */
    boolean deleteById(String flightnumber);

}

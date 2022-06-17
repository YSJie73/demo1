package com.example.service;

import com.example.entity.Passengers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;
/**
 * (Passengers)表服务接口
 *
 * @author makejava
 * @since 2022-06-15 09:12:56
 */
public interface PassengersService {

    /**
     * 通过ID查询单条数据
     *
     * @param ordernumber 主键
     * @return 实例对象
     */
    Passengers queryById(Integer ordernumber);

    /**
     * 分页查询
     *
     * @param passengers 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Passengers> queryByPage(Passengers passengers, PageRequest pageRequest);

 List<Passengers> queryAllByLimits(Passengers passengers, int offset,int pageSize);
    
    long count(Passengers passengers);
    /**
     * 新增数据
     *
     * @param passengers 实例对象
     * @return 实例对象
     */
    Passengers insert(Passengers passengers);

    /**
     * 修改数据
     *
     * @param passengers 实例对象
     * @return 实例对象
     */
    Passengers update(Passengers passengers);

    /**
     * 通过主键删除数据
     *
     * @param ordernumber 主键
     * @return 是否成功
     */
    boolean deleteById(Integer ordernumber);

}

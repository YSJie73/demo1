package com.example.dao;

import com.example.entity.Flight;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;



/**
 * (Flight)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-15 09:12:56
 */
public interface FlightDao {

    /**
     * 通过ID查询单条数据
     *
     * @param flightnumber 主键
     * @return 实例对象
     */
    Flight queryById(String flightnumber);

    /**
     * 查询指定行数据
     *
     * @param flight 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Flight> queryAllByLimit(Flight flight, @Param("pageable") Pageable pageable);


    List<Flight> queryAllByLimits(@Param("Flight") Flight flight,@Param("page") int offset,@Param("pageSize") int pageSize);

    /**
     * 统计总行数
     *
     * @param flight 查询条件
     * @return 总行数
     */
    long count(Flight flight);

    /**
     * 新增数据
     *
     * @param flight 实例对象
     * @return 影响行数
     */
    int insert(Flight flight);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Flight> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Flight> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Flight> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Flight> entities);

    /**
     * 修改数据
     *
     * @param flight 实例对象
     * @return 影响行数
     */
    int update(Flight flight);

    /**
     * 通过主键删除数据
     *
     * @param flightnumber 主键
     * @return 影响行数
     */
    int deleteById(String flightnumber);

}


package com.example.service;

import com.example.entity.Classes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;
/**
 * (Classes)表服务接口
 *
 * @author makejava
 * @since 2022-06-15 09:12:56
 */
public interface ClassesService {

    /**
     * 通过ID查询单条数据
     *
     * @param classnumber 主键
     * @return 实例对象
     */
    Classes queryById(String classnumber);

    /**
     * 分页查询
     *
     * @param classes 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Classes> queryByPage(Classes classes, PageRequest pageRequest);

 List<Classes> queryAllByLimits(Classes classes, int offset,int pageSize);
    
    long count(Classes classes);
    /**
     * 新增数据
     *
     * @param classes 实例对象
     * @return 实例对象
     */
    Classes insert(Classes classes);

    /**
     * 修改数据
     *
     * @param classes 实例对象
     * @return 实例对象
     */
    Classes update(Classes classes);

    /**
     * 通过主键删除数据
     *
     * @param classnumber 主键
     * @return 是否成功
     */
    boolean deleteById(String classnumber);

}

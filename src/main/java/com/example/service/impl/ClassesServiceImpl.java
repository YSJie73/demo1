package com.example.service.impl;

import com.example.entity.Classes;
import com.example.dao.ClassesDao;
import com.example.service.ClassesService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import javax.annotation.Resource;

/**
 * (Classes)表服务实现类
 *
 * @author makejava
 * @since 2022-06-15 10:18:54
 */
@Service("classesService")
public class ClassesServiceImpl implements ClassesService {
    @Resource
    private ClassesDao classesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param classnumber 主键
     * @return 实例对象
     */
    @Override
    public Classes queryById(String classnumber) {
        return this.classesDao.queryById(classnumber);
    }

    /**
     * 分页查询
     *
     * @param classes 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Classes> queryByPage(Classes classes, PageRequest pageRequest) {
        long total = this.classesDao.count(classes);
        return new PageImpl<>(this.classesDao.queryAllByLimit(classes, pageRequest), pageRequest, total);
    }
    
     @Override
    public List<Classes> queryAllByLimits(Classes classes, int offset, int pageSize) {
        return this.classesDao.queryAllByLimits(classes,(offset-1)*pageSize,pageSize);
    }
    
     @Override
    public long count(Classes classes) {
        long total = this.classesDao.count(classes);
        return total;
    }

    /**
     * 新增数据
     *
     * @param classes 实例对象
     * @return 实例对象
     */
    @Override
    public Classes insert(Classes classes) {
        this.classesDao.insert(classes);
        return classes;
    }

    /**
     * 修改数据
     *
     * @param classes 实例对象
     * @return 实例对象
     */
    @Override
    public Classes update(Classes classes) {
        this.classesDao.update(classes);
        return this.queryById(classes.getClassnumber());
    }

    /**
     * 通过主键删除数据
     *
     * @param classnumber 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String classnumber) {
        return this.classesDao.deleteById(classnumber) > 0;
    }
}

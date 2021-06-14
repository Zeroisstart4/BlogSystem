package com.blog.service;

import com.blog.dao.TypeDao;
import com.blog.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhou
 * @create 2021-6-14 15:43
 */
@Service
public class TypeService {

    @Autowired
    private TypeDao typeDao;

    //事务注解
    @Transactional
    public int saveType(Type type) {
        return typeDao.saveType(type);
    }

    @Transactional
    public Type getType(Long id) {
        return typeDao.getType(id);
    }

    @Transactional
    public Type getTypeByName(String name) {
        return typeDao.getTypeByName(name);
    }

    @Transactional
    public List<Type> getAllType() {
        return typeDao.getAllType();
    }


    public List<Type> getBlogType() {
        return typeDao.getBlogType();
    }

    @Transactional
    public int updateType(Type type) {
        return typeDao.updateType(type);
    }

    @Transactional
    public int deleteType(Long id) {
        return typeDao.deleteType(id);
    }
}

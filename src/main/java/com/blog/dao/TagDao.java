package com.blog.dao;

import com.blog.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhou
 * @create 2021-6-14 15:33
 */
@Mapper
@Repository
public interface TagDao {

    int saveTag(Tag tag);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    List<Tag> getAllTag();

    //首页展示博客标签
    List<Tag> getBlogTag();

    int updateTag(Tag tag);

    int deleteTag(Long id);
}

package com.blog.dao;

import com.blog.pojo.BlogAndTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.blog.pojo.Blog;

import java.util.List;

/**
 * @author zhou
 * @create 2021-6-14 15:06
 */

@Mapper
@Repository
public interface BlogDao {

    // 后台展示博客
    Blog getBlog(Long id);
    // 获取博客详情
    Blog getDetailedBlog(@Param("id") Long id);
    // 获取所有博客
    List<Blog> getAllBlog();
    // 根据类型id获取博客
    List<Blog> getByTypeId(Long typeId);
    // 根据标签id获取博客
    List<Blog> getByTagId(Long tagId);
    // 主页博客展示
    List<Blog> getIndexBlog();
    // 推荐博客展示
    List<Blog> getAllRecommendBlog();
    // 全局搜索博客
    List<Blog> getSearchBlog(String query);
    // 后台根据标题、分类、推荐搜索博客
    List<Blog> searchAllBlog(Blog blog);
    // 查询所有年份，返回一个集合
    List<String> findGroupYear();
    // 按年份查询博客
    List<Blog> findByYear(@Param("year") String year);
    // 保存博客
    int saveBlog(Blog blog);
    // 保存博客与标签
    int saveBlogAndTag(BlogAndTag blogAndTag);
    // 更新博客
    int updateBlog(Blog blog);
    // 删除博客
    int deleteBlog(Long id);

}

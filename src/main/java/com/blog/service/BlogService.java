package com.blog.service;

import com.blog.dao.BlogDao;
import com.blog.exception.NotFoundException;
import com.blog.pojo.Blog;
import com.blog.pojo.BlogAndTag;
import com.blog.pojo.Tag;
import com.blog.util.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author zhou
 * @create 2021-6-14 15:36
 */

@Service
public class BlogService {
    // 自动注入
    @Autowired
    BlogDao blogDao;

    // 后台展示博客
    public Blog getBlog(Long id) {
        return blogDao.getBlog(id);
    }

    // 获取博客详情
    public Blog getDetailedBlog(Long id) {
        Blog blog = blogDao.getDetailedBlog(id);
        if (blog == null) {
            throw new NotFoundException("该博客不存在");
        }
        String content = blog.getContent();
        blog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));  //将Markdown格式转换成html
        return blog;
    }

    // 获取所有博客
    public List<Blog> getAllBlog() {
        return blogDao.getAllBlog();
    }

    // 根据类型id获取博客
    public List<Blog> getByTypeId(Long typeId) {
        return blogDao.getByTypeId(typeId);
    }

    // 根据标签id获取博客
    public List<Blog> getByTagId(Long tagId) {
        return blogDao.getByTagId(tagId);
    }

    // 主页博客展示
    public List<Blog> getIndexBlog() {
        return blogDao.getIndexBlog();
    }

    // 推荐博客展示
    public List<Blog> getAllRecommendBlog() {
        return blogDao.getAllRecommendBlog();
    }

    // 全局搜索博客
    public List<Blog> getSearchBlog(String query) {
        return blogDao.getSearchBlog(query);
    }

    // 查询所有年份，返回一个集合, 按年份查询博客
    public Map<String, List<Blog>> archiveBlog() {
        List<String> years = blogDao.findGroupYear();
        Set<String> set = new HashSet<>(years);  //set去掉重复的年份
        Map<String, List<Blog>> map = new HashMap<>();
        for (String year : set) {
            map.put(year, blogDao.findByYear(year));
        }
        return map;
    }

    // 统计博客数量
    public int countBlog() {
        return blogDao.getAllBlog().size();
    }

    // 后台根据标题、分类、推荐搜索博客
    public List<Blog> searchAllBlog(Blog blog) {
        return blogDao.searchAllBlog(blog);
    }


    // 新增博客
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        //保存博客
        blogDao.saveBlog(blog);
        //保存博客后才能获取自增的id
        Long id = blog.getId();
        //将标签的数据存到t_blogs_tag表中
        List<Tag> tags = blog.getTags();
        BlogAndTag blogAndTag = null;
        for (Tag tag : tags) {
            //新增时无法获取自增的id,在mybatis里修改
            blogAndTag = new BlogAndTag(tag.getId(), id);
            blogDao.saveBlogAndTag(blogAndTag);
        }
        return 1;
    }

    // 编辑博客
    public int updateBlog(Blog blog) {
        blog.setUpdateTime(new Date());
        //将标签的数据存到t_blogs_tag表中
        List<Tag> tags = blog.getTags();
        BlogAndTag blogAndTag = null;
        for (Tag tag : tags) {
            blogAndTag = new BlogAndTag(tag.getId(), blog.getId());
            blogDao.saveBlogAndTag(blogAndTag);
        }
        return blogDao.updateBlog(blog);
    }

    // 删除博客
    public int deleteBlog(Long id) {
        return blogDao.deleteBlog(id);
    }
}

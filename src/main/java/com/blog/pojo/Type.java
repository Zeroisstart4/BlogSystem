package com.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhou
 * @create 2021-6-14 12:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// 博客类型实体类
public class Type {
    // 博客类型 id
    public Long id;
    // 博客类型名称
    private String name;
    // 博客类型对应的博客集
    private List<Blog> blogs = new ArrayList<>();
}

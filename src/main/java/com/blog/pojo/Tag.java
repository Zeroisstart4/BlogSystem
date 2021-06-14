package com.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhou
 * @create 2021-6-14 12:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// 标签实体类
public class Tag {
    // 标签 id
    private Long id;
    // 标签名称
    private String name;
    // 标签对应的博客集
    private List<Blog> blogs = new ArrayList<>();
}

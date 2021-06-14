package com.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhou
 * @create 2021-6-14 12:31
 */
// 把博客和标签关系存到数据库中使用的类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogAndTag {

    // 标签 id
    private Long tagId;
    // 博客 id
    private Long blogId;
}

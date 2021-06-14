package com.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhou
 * @create 2021-6-14 12:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// 用户实体类
public class User {
    // 用户 id
    private Long id;
    // 用户昵称
    private String nickname;
    // 用户名
    private String username;
    // 用户密码
    private String password;
    // 用户邮箱
    private String email;
    // 用户头像
    private String avatar;
    // 用户类型
    private Integer type;
    // 用户创建时间
    private Date createTime;
    // 用户更新时间
    private Date updateTime;
    // 用户发表的博客
    private List<Blog> blogs = new ArrayList<>();
}

package com.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhou
 * @create 2021-6-14 14:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// 评论实体类
public class Comment {

    // 评论 id
    private Long id;
    // 评论昵称
    private String nickname;
    // 评论邮箱
    private String email;
    // 评论内容
    private String content;
    // 评论的主评论
    private boolean adminComment;
    // 头像
    private String avatar;
    // 评论创建时间
    private Date createTime;
    // 博客 id
    private Long blogId;
    // 父评论 id
    private Long parentCommentId;
    // 父评论昵称
    private String parentNickname;
    // 父评论内容
    private Comment parentComment;
    // 博客实体
    private Blog blog;
}

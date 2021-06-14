package com.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhou
 * @create 2021-6-14 12:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// 博客实体类
public class Blog {
    // 博客 id
    private Long id;
    // 博客标题
    private String title;
    // 博客内容
    private String content;
    // 博客图片
    private String firstPicture;
    // 博客标签
    private String flag;
    // 博客浏览数
    private Integer views;
    // 博客点赞数
    private boolean appreciation;
    // 博客分享数
    private boolean shareStatement;
    // 博客可否评论
    private boolean commentabled;
    // 博客可否发表
    private boolean published;
    // 博客可否推荐
    private boolean recommend;
    // 博客创建时间
    private Date createTime;
    // 博客更新时间
    private Date updateTime;

    //这个属性用来在mybatis中进行连接查询的
    // 博客类型 id
    private Long typeId;
    // 博客用户 id
    private Long userId;

    //获取多个标签的id
    private String tagIds;
    // 博客描述
    private String description;
    // 博客类型
    private Type type;
    // 博客用户
    private User user;
    // 博客标签集
    private List<Tag> tags = new ArrayList<>();
    // 博客评论集
    private List<Comment> comments = new ArrayList<>();

    public void init(){
        this.tagIds = tagsToIds(this.getTags());
    }

    //将tags集合转换为tagIds字符串形式：“1,2,3”,用于编辑博客时显示博客的tag
    private String tagsToIds(List<Tag> tags){
        if(!tags.isEmpty()){
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for(Tag tag: tags){
                if(flag){
                    ids.append(",");
                }else {
                    flag = true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        }else {
            return tagIds;
        }
    }
}

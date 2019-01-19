package com.dao;

import com.bean.Dept;
import com.bean.Post;

import java.util.List;

public interface PostDao {
    /**
     * 添加
     */
    public void addPost(Post post);

    /**
     * 查询全部
     */
    public List<Post> getAllPost();
    /**
     * 根据did查找dept
     */
    public Post getPostByPid(int pid);

    /**
     * 删除
     */
    public void delPost(int did);
    /**
     * 修改更新
     */
    public void updatePost(Post post);


    public  List<Post> getPostByNameAndDid(String name,int did);
}

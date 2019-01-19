package com.service;

import com.bean.Post;
import com.dao.PostDao;
import com.dao.PostDaoImpl;

import java.util.List;

public class PostServiceImpl implements PostService {

    PostDao pd=new PostDaoImpl();
    @Override
    public void addPost(Post post) {
        pd.addPost(post);
    }

    @Override
    public List<Post> getPostByNameAndDid(String name, int did) {
        System.out.println(pd.getPostByNameAndDid(name,did));
        return pd.getPostByNameAndDid(name,did);
    }

    @Override
    public List<Post> getAllPost() {
        System.out.println(pd.getAllPost());
        return pd.getAllPost();
    }

    @Override
    public Post getPostByPid(int pid) {
        return pd.getPostByPid(pid);
    }

    @Override
    public void updatePost(Post post) {
        pd.updatePost(post);
    }

    @Override
    public void delPost(int pid) {
            pd.delPost(pid);
    }
}

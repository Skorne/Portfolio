package dao;

import models.Post;
import models.User;

import java.util.List;

public interface PostDAO {
    public boolean createPost(Post post);
    public List<Post> getAllPosts();
    public Post getPostByID(int id);
    public boolean updatePost(Post post);
    public boolean deletePost(Post post);
}


package service;

import dao.PostDAO;
import dao.PostDAOImpl;
import models.Post;
import models.User;

import java.io.Serializable;
import java.util.List;

public class PostServiceImpl implements PostService {
    PostDAO postDAO;
    /**@param post new post object being created
     * @return true if sucessful
     */
    @Override
    public boolean createPost(Post post) {

        return postDAO.createPost(post);
    }

    /**@return array list of post objects
     */
    @Override
    public List<Post> getAllPosts() {
        return postDAO.getAllPosts();
    }

    /**WARNING!!!! NOT IMPLEMENTED!!!!
     * currently returns null
     *
     * @param id  The unique Post's ID
     * @return list of post objects
     */
    @Override
    public Post getPostByID(int id) {

        return postDAO.getPostByID(id);
    }

    /**@param post updated post object
     * @return true if successful
     */
    @Override
    public boolean updatePost(Post post) {
        return postDAO.updatePost(post);
    }

    /**@param post post object to be deleted
     * @return true if successful
     */
    @Override
    public boolean deletePost(Post post) {
        return postDAO.deletePost(post);
    }
}

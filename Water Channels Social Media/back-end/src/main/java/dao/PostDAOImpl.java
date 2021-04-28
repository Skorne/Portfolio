package dao;

import Util.HibernateUtil;
import models.Post;
import models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PostDAOImpl implements PostDAO{
    private SessionFactory sesFact;

    /**@param post new post object
     * @return true if successful
     *
     */
    @Override
    public boolean createPost(Post post) {
   /*     Session session= HibernateUtil.getSession();
        Transaction transaction= session.beginTransaction();

        session.save(post);
        transaction.commit();*/

        sesFact.getCurrentSession().save(post);
        return true;
    }

    /**@return list of all post objects
     *
     */
    @Override
    public List<Post> getAllPosts() {
        /*   Session session = HibernateUtil.getSession();

        List<Post> posts= session.createQuery("from Post", Post.class).list();
         return posts;
        */
        return sesFact.getCurrentSession().createQuery("from Post", Post.class).list();

    }

    /**@param  id  the UNIQUE Post's ID
     * @return list of post objects
     * 
     */
    @Override
    public Post getPostByID(int id) {
    /*    Session session= HibernateUtil.getSession();

        List<Post> posts= session.createQuery("from Post where user_id= '"
                +user.getUserID()+"';", Post.class).list();*/
        return sesFact.getCurrentSession().get(Post.class, id);
    }

    @Override
    public boolean updatePost(Post post) {
        Session session= HibernateUtil.getSession();
        Transaction transaction= session.beginTransaction();

        session.update(post);
        transaction.commit();
        return true;
    }

    @Override
    public boolean deletePost(Post post) {
        Session session= HibernateUtil.getSession();
        Transaction transaction= session.beginTransaction();

        session.delete(post);
        transaction.commit();
        return true;
    }
    //////////CONSTRUCTORS
    PostDAOImpl(){

    }
    PostDAOImpl(SessionFactory sesFact){
        this.sesFact = sesFact;

    }


    //////////GETTERS AND SETTERS
    public SessionFactory getSesFact() {
        return sesFact;
    }
    //   @Autowired
    public void setSesFact(SessionFactory sesFact) {
        this.sesFact = sesFact;
    }
}

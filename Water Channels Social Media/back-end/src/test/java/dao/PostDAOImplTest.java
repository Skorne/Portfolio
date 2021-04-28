package dao;

import models.Post;
import models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.UserService;
import service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostDAOImplTest {

    @BeforeEach
    void setUp() {
        UserService userService= new UserServiceImpl();
        //need 2 users, 1 post pre-populated
        User user1= new User();
        user1.setUsername("testUser1");
        user1.setFirstName("fName");
        user1.setLastName("lName");
        user1.setEmail("test1@email.com");

        userService.createUser(user1);


        User user2= new User();
        user2.setUsername("testUser2");
        user2.setFirstName("fName");
        user2.setLastName("lName");
        user2.setEmail("test2@email.com");

        userService.createUser(user2);


        Post post1= new Post();
        post1.setUserID(user1);
        post1.setBody("test post body");
        post1.setLikes(new ArrayList<>());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createPost() {
    }

    @Test
    void getAllPosts() {
    }

    @Test
    void getPostByID() {
    }

    @Test
    void updatePost() {
    }

    @Test
    void deletePost() {
    }
}
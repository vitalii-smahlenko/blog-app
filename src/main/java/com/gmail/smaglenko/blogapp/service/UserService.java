package com.gmail.smaglenko.blogapp.service;

import com.gmail.smaglenko.blogapp.model.Color;
import com.gmail.smaglenko.blogapp.model.User;
import java.util.List;

public interface UserService {

    User addArticleToUser(Long userId, String text, Color color);
    User findByName(String name);
    List<User> getAllByAgeAfter(int age);

    List<String> getUsersWithUniqueNameAndMoreThanThreeArticle();

    User save(User user);

    List<User> getUsersWithArticleColor(Color color);
}

package com.gmail.smaglenko.blogapp.service.impl;

import com.gmail.smaglenko.blogapp.model.Article;
import com.gmail.smaglenko.blogapp.model.Color;
import com.gmail.smaglenko.blogapp.model.User;
import com.gmail.smaglenko.blogapp.repository.UserRepository;
import com.gmail.smaglenko.blogapp.service.ArticleService;
import com.gmail.smaglenko.blogapp.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ArticleService articleService;

    @Override
    public User addArticleToUser(Long userId, String text, Color color) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("Can't find user with ID: " + userId));
        Article article = new Article();
        article.setText(text);
        article.setColor(color);
        article = articleService.save(article);
        user.getArticles().add(article);
        return userRepository.save(user);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<User> getAllByAgeAfter(int age) {
        return userRepository.getAllByAgeAfter(age);
    }

    @Override
    public List<String> getUsersWithUniqueNameAndMoreThanThreeArticle() {
        return userRepository.getUsersWithUniqueNameAndMoreThanThreeArticle();
    }

    @Override
    public List<User> getUsersWithArticleColor(Color color) {
        return userRepository.getUsersWithArticleColor(color);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}

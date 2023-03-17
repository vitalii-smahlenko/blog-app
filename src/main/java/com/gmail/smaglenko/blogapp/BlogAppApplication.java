package com.gmail.smaglenko.blogapp;

import com.gmail.smaglenko.blogapp.model.Article;
import com.gmail.smaglenko.blogapp.model.Color;
import com.gmail.smaglenko.blogapp.model.Role;
import com.gmail.smaglenko.blogapp.model.User;
import com.gmail.smaglenko.blogapp.model.UserAuth;
import com.gmail.smaglenko.blogapp.repository.ArticleRepository;
import com.gmail.smaglenko.blogapp.repository.UserRepository;
import com.gmail.smaglenko.blogapp.service.UserAuthService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BlogAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogAppApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserRepository userRepository, ArticleRepository articleRepository,
                          UserAuthService userAuthService) {
        return args -> {
            /*UserAuth userAuth = new UserAuth();
            userAuth.setUsername("admin");
            userAuth.setPassword("admin");
            userAuth.getRoles().add(Role.ADMIN);
            userAuthService.save(userAuth);*/

            Random random = new Random();
            String[] names = new String[]{"Petro", "Daria", "Mariya", "Viktoria", "Anna", "Taras",
                    "Veronika"};
            for (int i = 0; i < random.nextInt((10 - 5) + 1) + 5; i++) {
                User user = new User();
                user.setName(names[random.nextInt(names.length)]);
                user.setAge((int) (Math.random() * 50) + 18);
                List<Article> articles = new ArrayList<>();
                for (int j = 0; j < random.nextInt(20); j++) {
                    Article article = new Article();
                    article.setText("Article " + j);
                    article.setColor(Color.values()[random.nextInt(Color.values().length)]);
                    articles.add(article);
                    articleRepository.save(article);
                }
                user.setArticles(articles);
                userRepository.save(user);
            }
        };
    }
}

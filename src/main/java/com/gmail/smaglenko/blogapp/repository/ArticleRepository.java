package com.gmail.smaglenko.blogapp.repository;

import com.gmail.smaglenko.blogapp.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}

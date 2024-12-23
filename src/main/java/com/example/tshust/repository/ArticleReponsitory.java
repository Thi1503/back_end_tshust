package com.example.tshust.repository;


import com.example.tshust.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleReponsitory extends JpaRepository<Article,Integer> {
    List<Article> findAllByTab(String tab);
    List<Article> findAllBySubTab(String subTab);

}

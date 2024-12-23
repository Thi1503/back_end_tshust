package com.example.tshust.service;

import com.example.tshust.entity.Article;
import com.example.tshust.repository.ArticleReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleReponsitory articleReponsitory;

    // Lấy tất cả bài viết
    public List<Article> getAllArticles() {
        return articleReponsitory.findAll();
    }

    // Lấy bài viết theo ID
    public Optional<Article> getArticleById(int id) {
        return articleReponsitory.findById(id);
    }

    // Lấy danh sách bài viết theo tab
    public List<Article> getArticleByTab(String tab) {
        return articleReponsitory.findAllByTab(tab);
    }

    public List<Article> getArticleBySubTab(String subTab) {
        return articleReponsitory.findAllBySubTab(subTab);
    }
}

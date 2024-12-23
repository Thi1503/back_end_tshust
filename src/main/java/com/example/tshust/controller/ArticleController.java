package com.example.tshust.controller;


import com.example.tshust.entity.Account;
import com.example.tshust.entity.Article;
import com.example.tshust.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> getAccounts() {
        return  articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public Optional<Article> getArticleById(@PathVariable int id) {
        return articleService.getArticleById(id);
    }

    @GetMapping("/by-tab")
    public List<Article> getArticlesByTab(@RequestParam String tab) {
        return articleService.getArticleByTab(tab);
    }

    @GetMapping("/recent-by-tab")
    public List<Article> getRecentArticlesByTab(@RequestParam String tab) {
        return articleService.getRecentArticlesByTab(tab);
    }


    @GetMapping("/by-sub-tab")
    public List<Article> getArticlesBySubTab(@RequestParam String subTab) {
        return articleService.getArticleBySubTab(subTab);
    }


    @GetMapping("/recent-articles")
    public List<Article> getRecentArticles() {
        return articleService.getRecentArticles();
    }

    @GetMapping("/search")
    public List<Article> searchArticles(@RequestParam String keyword) {
        return articleService.searchArticlesByTitle(keyword);
    }


}

package com.example.tshust.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Tab", length = 255)
    private String tab;

    @Column(name = "SubTab", length = 255)
    private String subTab;

    @Column(name = "SubSubTab", length = 255)
    private String subSubTab;

    @Column(name = "ImgURL", columnDefinition = "TEXT")
    private String imgURL;

    @Column(name = "Title", columnDefinition = "TEXT")
    private String title;

    @Column(name = "DateCreated")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    @Column(name = "SubDescription", columnDefinition = "TEXT")
    private String subDescription;

    @Column(name = "Link", columnDefinition = "TEXT")
    private String link;

    @Column(name = "HTMLContent", columnDefinition = "MEDIUMTEXT")
    private String htmlContent;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public String getSubTab() {
        return subTab;
    }

    public void setSubTab(String subTab) {
        this.subTab = subTab;
    }

    public String getSubSubTab() {
        return subSubTab;
    }

    public void setSubSubTab(String subSubTab) {
        this.subSubTab = subSubTab;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getSubDescription() {
        return subDescription;
    }

    public void setSubDescription(String subDescription) {
        this.subDescription = subDescription;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }
}
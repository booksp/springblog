package cn.booksp.sharebook.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * 文章实体类
 * @author warmfrog
 * @date 2018/12/28
 */

public class Article implements Serializable {
    private static final long serialVersionUID = 1995L;

    /**
     * 文章ID
     */
    private long id;

    /**
     * 标题
     */
    private String title;
    /**
     * 作者
     */
    private String author;
    /**
     * 类型
     */
    private String type;
    /**
     * 简介
     */
    private String intro;


    /**
     * 图像地址
     */
    private String imgUrl;
    /**
     * 页面地址
     */
    private String url;
    /**
     * 发布时间
     */
    private Timestamp date;

    private MultipartFile image;

    public MultipartFile getArticle() {
        return article;
    }

    public void setArticle(MultipartFile article) {
        this.article = article;
    }

    private MultipartFile article;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article airticle = (Article) o;
        return Objects.equals(title, airticle.title) &&
                Objects.equals(author, airticle.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    public Article(String title, String author, String type, String intro, Timestamp date) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.intro = intro;
        this.date = date;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Article() {
    }



}

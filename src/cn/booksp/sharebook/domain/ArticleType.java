package cn.booksp.sharebook.domain;

public class ArticleType {
    int id;
    String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArticleType() {
    }

    public ArticleType(String type) {
        this.type = type;
    }
}

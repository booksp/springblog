package cn.booksp.sharebook.dao;

import cn.booksp.sharebook.domain.Article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDaoImpl implements ArticleDao {

    private Connection conn;

    public ArticleDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean add(Article article) {
        try {
            PreparedStatement statement = conn.prepareStatement("insert into article (title, author, type, intro, url, date, imgUrl ) values (?, ?, ?, ?, ?, ?,?)");
            statement.setString(1, article.getTitle());
            statement.setString(2, article.getAuthor());
            statement.setString(3, article.getType());
            statement.setString(4, article.getIntro());
            statement.setString(5, article.getUrl());
            statement.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            statement.setString(7, article.getImgUrl());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean remove(long id) {
        try {
            PreparedStatement statement = conn.prepareStatement("delete from article where id = ?");
            statement.setLong(1, id);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Article article) {
        long id = article.getId();
        try {
            PreparedStatement statement = conn.prepareStatement("update article set title=?, author=?, type=?, intro=?, url=?, date=?, imgUrl=? where id = ?");
            statement.setString(1, article.getTitle());
            statement.setString(2, article.getAuthor());
            statement.setString(3, article.getType());
            statement.setString(4, article.getIntro());
            statement.setString(5, article.getUrl());
            statement.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            statement.setString(7, article.getImgUrl());
            statement.setLong(8, id);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List list() {
        List<Article> articles = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("select * from article");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Article article = new Article();
                article.setId(resultSet.getLong("id"));
                article.setTitle(resultSet.getString("title"));
                article.setAuthor(resultSet.getString("author"));
                article.setType(resultSet.getString("type"));
                article.setIntro(resultSet.getString("intro"));
                article.setDate(resultSet.getTimestamp("date"));
                article.setUrl(resultSet.getString("url"));
                article.setImgUrl(resultSet.getString("imgUrl"));

                articles.add(article);
            }

            return articles;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List list(int currentPage, int pageSize) {

        List<Article> articles = new ArrayList<>();

        try {
            PreparedStatement statement = conn.prepareStatement("select * from article limit ?,?");
            statement.setInt(1, currentPage*pageSize);
            statement.setInt(2, pageSize);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Article article = new Article();
                article.setId(resultSet.getLong("id"));
                article.setTitle(resultSet.getString("title"));
                article.setAuthor(resultSet.getString("author"));
                article.setType(resultSet.getString("type"));
                article.setIntro(resultSet.getString("intro"));
                article.setDate(resultSet.getTimestamp("date"));
                article.setUrl(resultSet.getString("url"));
                article.setImgUrl(resultSet.getString("imgUrl"));

                articles.add(article);
            }

            return articles;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List list(int currentPage, int pageSize, String column, String keyWord) {
        List<Article> articles = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("select * from article where ? like %?% limit ?,?");
            statement.setString(1, column);
            statement.setString(2, keyWord);
            statement.setInt(3, currentPage*pageSize);
            statement.setInt(4, pageSize);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Article article = new Article();
                article.setId(resultSet.getLong("id"));
                article.setTitle(resultSet.getString("title"));
                article.setAuthor(resultSet.getString("author"));
                article.setType(resultSet.getString("type"));
                article.setIntro(resultSet.getString("intro"));
                article.setDate(resultSet.getTimestamp("date"));
                article.setUrl(resultSet.getString("url"));
                article.setImgUrl(resultSet.getString("imgUrl"));

                articles.add(article);
            }

            return articles;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Article find(long id) {
        try {
            PreparedStatement statement = conn.prepareStatement("select * from article where id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            Article article = new Article();
            if (resultSet.next()) {
                article.setId(resultSet.getLong("id"));
                article.setTitle(resultSet.getString("title"));
                article.setAuthor(resultSet.getString("author"));
                article.setType(resultSet.getString("type"));
                article.setIntro(resultSet.getString("intro"));
                article.setDate(resultSet.getTimestamp("date"));
                article.setUrl(resultSet.getString("url"));
                article.setImgUrl(resultSet.getString("imgUrl"));
            }

            return article;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

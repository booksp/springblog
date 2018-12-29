package cn.booksp.sharebook.dao;

import java.sql.Connection;

public class DaoFactory {
    public static ArticleDao getAirticleDao(Connection conn){
        return  new ArticleDaoImpl(conn);
    }
    public static UserDao getUserDao(Connection conn){
        return  new UserDaoImpl(conn);
    }

    public static ArticleTypeDao getAirticleTypeDao(Connection conn){
        return new ArticleTypeDaoImpl(conn);
    }
}

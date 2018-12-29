package cn.booksp.sharebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleTypeDaoImpl implements ArticleTypeDao {

    Connection conn;

    public ArticleTypeDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List list() {
        try {
            PreparedStatement statement = conn.prepareStatement("select type from airticle_type");
            ResultSet resultSet = statement.executeQuery();
            List<String> typeList = new ArrayList<>();
            while (resultSet.next()) {
                String type = resultSet.getString("type");
                typeList.add(type);
            }
            return typeList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package cn.booksp.sharebook.dao;

import cn.booksp.sharebook.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    Connection conn;

    public UserDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean exist(String username) {
        try {
            PreparedStatement statement = conn.prepareStatement("select * from user where username = ?");
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean verify(User user) {
        if (exist(user.getUsername())) {
            PreparedStatement statement = null;
            try {
                statement = conn.prepareStatement("select password from user where username= ?");
                statement.setString(1, user.getUsername());
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    String password = resultSet.getString(1);
                    if (user.getPassword().equals(password)) {
                        return true;
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }


}

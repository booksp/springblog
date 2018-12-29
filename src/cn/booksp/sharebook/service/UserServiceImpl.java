package cn.booksp.sharebook.service;

import cn.booksp.sharebook.dao.DaoFactory;
import cn.booksp.sharebook.dao.UserDao;
import cn.booksp.sharebook.domain.User;
import cn.booksp.sharebook.util.JdbcUtil;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public class UserServiceImpl implements UserService {

    Connection conn = JdbcUtil.getDBConn();
    private UserDao userDao = DaoFactory.getUserDao(conn);

    @Override
    public boolean verify(User user) {
        return userDao.verify(user);
    }
}

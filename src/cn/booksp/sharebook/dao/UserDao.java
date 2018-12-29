package cn.booksp.sharebook.dao;

import cn.booksp.sharebook.domain.User;

import java.sql.SQLException;

public interface UserDao {

    /**
     * 根据用户名查看用户是否存在
     * @param username
     * @return
     */
    public boolean exist(String username);

    /**
     * 校验用户名和密码
     * @param user
     * @return
     */
    public boolean verify(User user);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username);
}

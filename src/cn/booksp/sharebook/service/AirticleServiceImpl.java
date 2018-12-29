package cn.booksp.sharebook.service;

import cn.booksp.sharebook.dao.ArticleDao;
import cn.booksp.sharebook.dao.ArticleTypeDao;
import cn.booksp.sharebook.dao.DaoFactory;
import cn.booksp.sharebook.domain.Article;
import cn.booksp.sharebook.util.JdbcUtil;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
public class AirticleServiceImpl implements AirticleService {

    Connection conn = JdbcUtil.getDBConn();
    ArticleDao articleDao = DaoFactory.getAirticleDao(conn);

    @Override
    public boolean release(Article airticle) {
        return articleDao.add(airticle);
    }

    @Override
    public boolean delete(long id) {
        return articleDao.remove(id);
    }

    @Override
    public boolean update(Article airticle) {
        return articleDao.update(airticle);
    }

    @Override
    public List findByType(String type) {
        return null;
    }

    @Override
    public List findByTitle(String title) {
        return null;
    }

    @Override
    public List findByAuthor(String author) {
        return null;
    }

    @Override
    public List findAll() {
        return articleDao.list();
    }

    @Override
    public List loadPage(int currentPage, int pageSize) {
        return articleDao.list(currentPage, pageSize);
    }

    @Override
    public List getTypes() {
        ArticleTypeDao typeDao = DaoFactory.getAirticleTypeDao(conn);
        return typeDao.list();
    }
}

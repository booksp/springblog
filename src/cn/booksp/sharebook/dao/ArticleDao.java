package cn.booksp.sharebook.dao;

import cn.booksp.sharebook.domain.Article;

import java.util.List;

public interface ArticleDao {

    /**
     * 添加文章
     * @param airticle
     * @return
     */
    public boolean add(Article airticle);

    /**
     * 根据id移除文章
     * @param id
     * @return
     */
    public boolean remove(long id);

    /**
     * 更新文章
     * @param airticle
     * @return
     */
    public boolean update(Article airticle);

    /**
     * 列出所有文章
     * @return 返回所有文章列表
     */
    public List list();

    /**
     * 获得指定页面文章列表
     * @param currentPage 当前页
     * @param pageSize 页面记录数
     * @return 文章列表
     */
    public List list(int currentPage, int pageSize);

    /**
     * 根据关键字分页查询
     * @param currentPage 当前页
     * @param pageSize 每页面记录数
     * @param column 关键字查询列
     * @param keyWord 关键字
     * @return 返回文章列表
     */
    public List list(int currentPage, int pageSize, String column, String keyWord);

    /**
     * 根据文章id查找文章
     * @param id
     * @return
     */
    public Article find(long id);
}

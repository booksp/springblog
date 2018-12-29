package cn.booksp.sharebook.service;

import cn.booksp.sharebook.domain.Article;

import java.util.List;

public interface AirticleService {

    /**
     * 发布文章
     * @param airticle
     * @return
     */
    public boolean release(Article airticle);

    /**
     * 删除文章
     * @param id
     */
    public boolean delete(long id);

    /**
     * 更新文章
     * @param airticle
     * @return
     */
    public boolean update(Article airticle);

    /**
     * 根据类型查找文章
     * @param type
     * @return
     */
    public List findByType(String type);

    /**
     * 根据文章标题查找文章
     * @param title
     * @return
     */
    public List findByTitle(String title);

    /**
     * 根据作者查找文章
     * @param author
     * @return 文章列表
     */
    public List findByAuthor(String author);

    /**
     * 查找所有文章
     * @return
     */
    public List findAll();

    /**
     * 分页查找文章
     * @param currentPage 当前页
     * @param pageSize 页面记录数
     * @return 文章列表
     */
    public List loadPage(int currentPage, int pageSize);

    /**
     * 获取文章分类
     * @return
     */
    public List getTypes();



}

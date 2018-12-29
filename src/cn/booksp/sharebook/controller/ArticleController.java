package cn.booksp.sharebook.controller;

import cn.booksp.sharebook.domain.Article;
import cn.booksp.sharebook.service.AirticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private AirticleService articleService;

    @RequestMapping("/release")
    public String release(HttpSession session, RedirectAttributes redirectAttributes) {
        String user = (String) session.getAttribute("user");
        if (user == null) {
            redirectAttributes.addFlashAttribute("message", "暂不支持未登录用户发布文章");
            return "redirect:/error";
        } else {
            List types = articleService.getTypes();
            session.setAttribute("types", types);
            return "/article/release";
        }
    }

    @RequestMapping("/add")
    public String add(Article article, HttpServletRequest request) {

        ServletContext context = request.getServletContext();
        MultipartFile image = article.getImage();
        MultipartFile articleHtml = article.getArticle();


        String imagePath = context.getRealPath("img/") + image.getOriginalFilename();
        String articlePath = context.getRealPath("static/articles/") + articleHtml.getOriginalFilename();

        try {
            image.transferTo(new File(imagePath));
            articleHtml.transferTo(new File(articlePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        article.setUrl("/img/" + image.getOriginalFilename());
        article.setImgUrl("/static/articles/" + image.getOriginalFilename());
        articleService.release(article);

        return "redirect:/article/list";
    }

    @RequestMapping("/manage")
    public String manage(HttpSession session, RedirectAttributes redirectAttributes) {
        String user = (String) session.getAttribute("user");
        if (user == null) {
            redirectAttributes.addFlashAttribute("message", "暂不支持未登录用户执行该操作");
            return "redirect:/error";
        } else {
            return "/article/manage";
        }
    }

    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.POST, RequestMethod.GET})
    public String delete(@PathVariable long id, HttpSession session) {
        articleService.delete(id);
        session.removeAttribute("articles");
        List articles = articleService.loadPage(0, 20);
        session.setAttribute("articles", articles);
        return "/article/manage";
    }

    @RequestMapping("/update")
    public void update(Article article) {
        articleService.update(article);

        return;
    }

    @RequestMapping("/list")
    public String list(HttpSession session) {
        List articles = articleService.loadPage(0, 20);
        List types = articleService.getTypes();
        session.setAttribute("articles", articles);
        session.setAttribute("types", types);

        return "index";
    }


}

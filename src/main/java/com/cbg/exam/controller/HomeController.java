package com.cbg.exam.controller;

import com.cbg.exam.domain.entity.Article;
import com.cbg.exam.domain.entity.Board;
import com.cbg.exam.domain.entity.Member;
import com.cbg.exam.repository.ArticleRepository;
import com.cbg.exam.service.ArticleService;
import com.cbg.exam.service.BoardService;
import com.cbg.exam.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;
    private final ArticleService articleService;
    private final BoardService boardService;

    // 홈화면
    @GetMapping("/")
    public String home(Model model){
        List<Board> boardList = boardService.findAll();
        List<Article> recentArticleList = articleService.getRecentArticles();

        model.addAttribute("boardList", boardList);
        model.addAttribute("recentArticleList", recentArticleList);
        return "home";
    }

    @GetMapping("/test/toastUiTest")
    public String showToastUi(){
        return "test/toastUiTest";
    }
}

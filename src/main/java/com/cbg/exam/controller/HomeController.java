package com.cbg.exam.controller;

import com.cbg.exam.domain.Article;
import com.cbg.exam.domain.Member;
import com.cbg.exam.service.ArticleService;
import com.cbg.exam.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;
    private final ArticleService articleService;

    @GetMapping("/")
    public String home(){

        String logonMemberName = "";


        // 로그인한 회원 정보 가져오기(아이디)
        Object logonMember = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(logonMember instanceof UserDetails){
            logonMemberName = ((UserDetails) logonMember).getUsername();

        }else{
            logonMemberName = logonMember.toString();
        }

        System.out.println("로그인한 회원 : " + logonMemberName);

        return "home";
    }

    @GetMapping("/home/maketest")
    public String makeTest(){

        memberService.save("aa","aa", "aa", "aa", "aa@gmail.com");

        for(int i = 1; i <= 10; i++){
            Article article =  Article.builder()
                    .memberId(1L)
                    .boardId(1L)
                    .title("제목 : " + i)
                    .body("내용 : " + i)
                    .build();
            articleService.save(article);
        }

        return "redirect:/";
    }
}

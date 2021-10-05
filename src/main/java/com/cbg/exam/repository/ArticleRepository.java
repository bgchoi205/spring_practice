package com.cbg.exam.repository;

import com.cbg.exam.domain.entity.Article;
import com.cbg.exam.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {


}

//@Repository
//@RequiredArgsConstructor
//public class ArticleRepository {
//
//    private final EntityManager em;
//
//    public Long save(Article article){
//        em.persist(article);
//        return article.getId();
//    }
//
//    public Long delete(Article article){
//        em.remove(article);
//        return article.getId();
//    }
//
//    public Long modify(Article article){
//        return save(article);
//    }
//
//    public Article findById(int id){
//        return em.find(Article.class, id);
//    }
//
//    public List findAll(){
//        return em.createQuery("SELECT a FROM Article a")
//                .getResultList();
//    }
//}


package com.spring.blog.controller;

import com.spring.blog.domain.Blog;
import com.spring.blog.repository.BlogRepository;
import com.spring.blog.dto.BlogRequestDto;
import com.spring.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogController {
    private final BlogRepository blogRepository;
    private final BlogService blogService;

    @PostMapping("/api/blogs")
    public Blog createBlog(@RequestBody BlogRequestDto requestDto){
        Blog blog = new Blog(requestDto);
        return blogRepository.save(blog);
    }

    @GetMapping("/api/blogs")
    public List<Blog> readBlog(){
        return blogRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/api/blogs/{id}")
    public Blog read_one_Blog(@PathVariable Long id){
         return blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
    }

    @DeleteMapping("/api/blogs/{id}")
    public Long deleteBlog(@PathVariable Long id) {
        blogRepository.deleteById(id);
        return id;
    }
    @PutMapping("/api/blogs/{id}")
    public Long updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto){
        blogService.update(id,requestDto);
        return id;
    }

}

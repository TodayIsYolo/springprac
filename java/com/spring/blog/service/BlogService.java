package com.spring.blog.service;

import com.spring.blog.domain.Blog;
import com.spring.blog.repository.BlogRepository;
import com.spring.blog.dto.BlogRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    @Transactional
    public Long update(Long id, BlogRequestDto requestDto) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 글 입니다.")
        );
        blog.update(requestDto);
        return blog.getId();
    }

}
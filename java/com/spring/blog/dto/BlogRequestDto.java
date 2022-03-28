package com.spring.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BlogRequestDto {
    private String username;
    private String title;
    private String contents;
}

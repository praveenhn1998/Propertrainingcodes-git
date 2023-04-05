package com.myblog.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private long id;
    @NotEmpty
    @Size(min = 2,message = "title shold be atleast 2 characters ")
    private String title;
    @NotEmpty
    @Size(min = 5,message = "description shold be atleast 5 characters ")
    private String description;
    @NotEmpty
    @Size(min = 5,message = "content shold be atleast 5 characters ")
    private String content;
}

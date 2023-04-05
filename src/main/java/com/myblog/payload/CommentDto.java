package com.myblog.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private long comId;
    @NotEmpty
    @Size(min=2,message = "name should be at least 2 characters")
    private String name;
    @Email
    private String email;
    @NotEmpty
    @Size(min=5,message = "name should be at least 5characters")
    private String body;
}

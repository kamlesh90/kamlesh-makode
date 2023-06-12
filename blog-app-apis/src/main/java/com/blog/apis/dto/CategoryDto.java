package com.blog.apis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class CategoryDto {
    private Integer categoryId;
    @NotBlank
    @Size(min = 4, message = "Minimum category tittle size must be 4")
    private String categoryTittle;
    @NotBlank
    @Size(min = 10, message = "Minimum category Description size must be 10")
    private String categoryDescription;
}

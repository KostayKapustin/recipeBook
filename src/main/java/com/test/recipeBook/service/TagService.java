package com.test.recipeBook.service;

import com.test.recipeBook.dto.TagDto;
import com.test.recipeBook.model.Tag;

import java.util.List;

public interface TagService {
    TagDto addTag(TagDto tagDto);

    TagDto updateTag(Long id, TagDto tagDto);

    Tag getTag(Long id);

    void deleteTag(Long id);

    Long getTagByName(String tagName);

    List<Long> getRecipeIdByTagId(Long id);
}

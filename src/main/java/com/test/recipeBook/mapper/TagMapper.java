package com.test.recipeBook.mapper;

import com.test.recipeBook.dto.TagDto;
import com.test.recipeBook.model.Tag;

public class TagMapper {

    public static Tag toTag(TagDto tagDto) {
        Tag tag = new Tag();
        tag.setName(tagDto.getName());
        tag.setDescription(tagDto.getDescription());
        return tag;
    }

    public static TagDto toTagDto(Tag tag) {
        TagDto tagDto = new TagDto();
        tagDto.setName(tag.getName());
        tagDto.setDescription(tag.getDescription());
        return tagDto;
    }
}

package com.test.recipeBook.service.impl;

import com.test.recipeBook.dto.TagDto;
import com.test.recipeBook.exception.TagNotFoundException;
import com.test.recipeBook.mapper.TagMapper;
import com.test.recipeBook.model.Tag;
import com.test.recipeBook.repository.TagRepository;
import com.test.recipeBook.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public TagDto addTag(TagDto tagDto) {
        return TagMapper.toTagDto(tagRepository.save(TagMapper.toTag(tagDto)));
    }

    @Override
    public TagDto updateTag(Long id, TagDto tagDto) {
        Tag tag = tagRepository.findById(id).orElseThrow(() -> new TagNotFoundException(id));
        if(tagDto.getName() != null) tag.setName(tagDto.getName());
        if(tagDto.getDescription() != null) tag.setDescription(tagDto.getDescription());
        return TagMapper.toTagDto(tag);
    }

    @Override
    public Tag getTag(Long id) {
        return tagRepository.findById(id).orElseThrow(() -> new TagNotFoundException(id));
    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    public Long getTagByName(String tagName) {
        Long tagListId = tagRepository.getTagByName(tagName);
        return tagListId;
    }

    @Override
    public List<Long> getRecipeIdByTagId(Long id) {
        return tagRepository.getRecipeIdByTagId(id);
    }
}

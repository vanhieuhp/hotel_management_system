package com.vanhieu.service.impl;

import com.vanhieu.converter.ImageOfCateConverter;
import com.vanhieu.dto.ImageOfCateDto;
import com.vanhieu.entity.ImageOfCateEntity;
import com.vanhieu.repository.ImageOfCateRepository;
import com.vanhieu.service.IImageOfCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageOfCateService implements IImageOfCateService {

    @Autowired
    private ImageOfCateRepository repository;

    @Autowired
    private ImageOfCateConverter converter;

    @Override
    public List<ImageOfCateDto> findAll() {
        List<ImageOfCateEntity> entities = repository.findAll();
        List<ImageOfCateDto> result = new ArrayList<>();
        entities.forEach(entity -> result.add(converter.toDto(entity)));
        return result;
    }
}

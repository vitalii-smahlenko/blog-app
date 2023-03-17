package com.gmail.smaglenko.blogapp.service.mapper;

public interface RequestDtoMapper<D, M> {
    M mapToModel(D dto);
}
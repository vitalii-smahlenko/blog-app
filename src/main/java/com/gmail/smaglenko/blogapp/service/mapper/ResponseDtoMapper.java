package com.gmail.smaglenko.blogapp.service.mapper;

public interface ResponseDtoMapper<D, M> {
    D mapToDto(M m);
}
package com.jbobadilla.onetomany.service;

import java.util.List;

public interface IGenericService<T, ID, DTO> {
    List<DTO> findAll();
    DTO findById(ID id);
    DTO save(DTO requestDto);
    DTO update(ID id,DTO requestDto);
    void deleteById(ID id);
}

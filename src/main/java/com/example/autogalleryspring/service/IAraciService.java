package com.example.autogalleryspring.service;

import com.example.autogalleryspring.dto.AraciDTO;
import org.springframework.transaction.annotation.Transactional;

public interface IAraciService {
    @Transactional(readOnly = true)
    AraciDTO idyeGoreGetir(Long id);

    @Transactional(rollbackFor = Exception.class)
    AraciDTO araciKaydet(AraciDTO araci) throws Exception;

    AraciDTO araciGuncelle(AraciDTO araci) throws Exception;

    void araciSil(Long id);
}

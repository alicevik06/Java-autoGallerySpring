package com.example.autogalleryspring.service;

import com.example.autogalleryspring.dto.AracDTO;
import org.springframework.transaction.annotation.Transactional;

public interface IAracService {
    @Transactional(readOnly = true)
    AracDTO idyeGoreGetir(Long id);

    @Transactional(rollbackFor = Exception.class)
    AracDTO aracKaydet(AracDTO arac) throws Exception;

    AracDTO aracGuncelle(AracDTO arac) throws Exception;

    void aracSil(Long id);
}

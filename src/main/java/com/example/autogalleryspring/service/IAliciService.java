package com.example.autogalleryspring.service;

import com.example.autogalleryspring.dto.AliciDTO;
import org.springframework.transaction.annotation.Transactional;

public interface IAliciService {
    @Transactional(readOnly = true)
    AliciDTO idyeGoreGetir(Long id);

    @Transactional(rollbackFor = Exception.class)
    AliciDTO aliciKaydet(AliciDTO alici) throws Exception;

    AliciDTO aliciGuncelle(AliciDTO alici) throws Exception;

    void aliciSil(Long id);
}

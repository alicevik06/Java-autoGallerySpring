package com.example.autogalleryspring.service;

import com.example.autogalleryspring.dto.KisiDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IKisiService {
    @Transactional(readOnly = true)
    KisiDTO idyeGoreGetir(Long id);

    @Transactional(rollbackFor = Exception.class)
    KisiDTO kisiKaydet(KisiDTO kisi) throws Exception;

    KisiDTO kisiGuncelle(KisiDTO kisi) throws Exception;

    void kisiSil(Long id);

    List<KisiDTO> tumunuGetir();
}

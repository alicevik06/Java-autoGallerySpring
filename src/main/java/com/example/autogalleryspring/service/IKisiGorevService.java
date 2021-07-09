package com.example.autogalleryspring.service;

import com.example.autogalleryspring.dto.KisiGorevDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IKisiGorevService {
    @Transactional(readOnly = true)
    KisiGorevDTO idyeGoreGetir(Long id);

    @Transactional(rollbackFor = Exception.class)
    KisiGorevDTO kisiGorevKaydet(KisiGorevDTO kisiGorev) throws Exception;

    KisiGorevDTO kisiGorevGuncelle(KisiGorevDTO kisiGorev) throws Exception;

    void kisiGorevSil(Long id);

    List<KisiGorevDTO> tumunuGetir();
}

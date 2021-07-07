package com.example.autogalleryspring.service;

import com.example.autogalleryspring.dto.HareketDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IHareketService {
    @Transactional(readOnly = true)
    HareketDTO idyeGoreGetir(Long id);

    @Transactional(rollbackFor = Exception.class)
    HareketDTO hareketKaydet(HareketDTO hareket) throws Exception;

    HareketDTO hareketGuncelle(HareketDTO hareket) throws Exception;

    void hareketSil(Long id);

    List<HareketDTO> tumunuGetir();
}

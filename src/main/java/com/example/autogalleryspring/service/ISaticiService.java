package com.example.autogalleryspring.service;

import com.example.autogalleryspring.dto.SaticiDTO;
import org.springframework.transaction.annotation.Transactional;

public interface ISaticiService {
    @Transactional(readOnly = true)
    SaticiDTO idyeGoreGetir(Long id);

    @Transactional(rollbackFor = Exception.class)
    SaticiDTO saticiKaydet(SaticiDTO satici) throws Exception;

    SaticiDTO saticiGuncelle(SaticiDTO satici) throws Exception;

    void saticiSil(Long id);
}

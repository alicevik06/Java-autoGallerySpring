package com.example.autogalleryspring.service;

import com.example.autogalleryspring.dto.StokDTO;

public interface IStokService {


    StokDTO idyeGoreGetir(Long id);

    StokDTO stokKaydet(StokDTO stok) throws Exception;

    StokDTO stokGuncelle(StokDTO stok) throws Exception;

    void stokSil(Long id);
}

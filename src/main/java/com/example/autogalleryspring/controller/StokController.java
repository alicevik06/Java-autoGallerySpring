package com.example.autogalleryspring.controller;

import com.example.autogalleryspring.common.Util;
import com.example.autogalleryspring.dto.BaseResponse;
import com.example.autogalleryspring.dto.StokDTO;
import com.example.autogalleryspring.service.IStokService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RequestMapping("api/stok")
@RestController
public class StokController {

    private IStokService stokService;

    @Autowired
    public StokController(IStokService stokService)
    {
        this.stokService = stokService;
    }

    @RequestMapping("idye-gore-getir/{id}")
    public BaseResponse idyeGoreGetir(@PathVariable("id") Long id) {

        return Util.islemSonucGetir(stokService.idyeGoreGetir(id));
    }

    @RequestMapping(value = "kaydet", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse kaydet(@RequestBody StokDTO k) {

        try {
            return Util.islemSonucGetir(stokService.stokKaydet(k));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "guncelle", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse guncelle(@RequestBody StokDTO k) {

        try {
            return Util.islemSonucGetir(stokService.stokGuncelle(k));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "sil/{id}", method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable("id") Long id) {
        stokService.stokSil(id);
        return Util.islemSonucGetir(null);
    }

}

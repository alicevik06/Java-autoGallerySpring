package com.example.autogalleryspring.controller;

import com.example.autogalleryspring.common.Util;
import com.example.autogalleryspring.dto.BaseResponse;
import com.example.autogalleryspring.dto.HareketDTO;
import com.example.autogalleryspring.service.IHareketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RequestMapping("api/hareket")
@RestController
public class HareketController {
    private IHareketService hareketService;

    @Autowired
    public HareketController(IHareketService hareketService) {
        this.hareketService = hareketService;
    }

    @RequestMapping("idye-gore-getir/{id}")
    public BaseResponse idyeGoreGetir(@PathVariable("id") Long id) {

        return Util.islemSonucGetir(hareketService.idyeGoreGetir(id));
    }

    @RequestMapping("tumunu-getir")
    public BaseResponse tumunuGetir() {

        return Util.islemSonucGetir(hareketService.tumunuGetir());
    }

    @RequestMapping(value = "kaydet", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse kaydet(@RequestBody HareketDTO r) {

        try {
            return Util.islemSonucGetir(hareketService.hareketKaydet(r));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "guncelle", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse guncelle(@RequestBody HareketDTO r) {

        try {
            return Util.islemSonucGetir(hareketService.hareketGuncelle(r));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "sil/{id}", method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable("id") Long id) {
        hareketService.hareketSil(id);
        return Util.islemSonucGetir(null);
    }
}
    


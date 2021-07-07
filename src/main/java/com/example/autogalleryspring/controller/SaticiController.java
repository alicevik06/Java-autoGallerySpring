package com.example.autogalleryspring.controller;

import com.example.autogalleryspring.common.Util;
import com.example.autogalleryspring.dto.BaseResponse;
import com.example.autogalleryspring.dto.SaticiDTO;
import com.example.autogalleryspring.entity.Abstract.BaseEntity;
import com.example.autogalleryspring.service.ISaticiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/satici")
@RestController
public class SaticiController extends BaseEntity {
    private ISaticiService saticiService;

    @Autowired
    public SaticiController(ISaticiService saticiService) {
        this.saticiService = saticiService;
    }

    @RequestMapping("idye-gore-getir/{id}")
    public BaseResponse idyeGoreGetir(@PathVariable("id") Long id) {

        return Util.islemSonucGetir(saticiService.idyeGoreGetir(id));
    }

    @RequestMapping(value = "kaydet", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse kaydet(@RequestBody SaticiDTO k) {

        try {
            return Util.islemSonucGetir(saticiService.saticiKaydet(k));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "guncelle", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse guncelle(@RequestBody SaticiDTO k) {

        try {
            return Util.islemSonucGetir(saticiService.saticiGuncelle(k));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "sil/{id}", method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable("id") Long id) {
        saticiService.saticiSil(id);
        return Util.islemSonucGetir(null);
    }
}

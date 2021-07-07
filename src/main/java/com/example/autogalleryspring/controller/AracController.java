package com.example.autogalleryspring.controller;

import com.example.autogalleryspring.common.Util;
import com.example.autogalleryspring.dto.AracDTO;
import com.example.autogalleryspring.dto.BaseResponse;
import com.example.autogalleryspring.entity.Abstract.BaseEntity;
import com.example.autogalleryspring.service.IAracService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/arac")
@RestController
public class AracController extends BaseEntity{

    private IAracService aracService;

    @Autowired
    public AracController(IAracService aracService)
    {
        this.aracService = aracService;
    }

    @RequestMapping("idye-gore-getir/{id}")
    public BaseResponse idyeGoreGetir(@PathVariable("id") Long id) {

        return Util.islemSonucGetir(aracService.idyeGoreGetir(id));
    }

    @RequestMapping(value = "kaydet", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse kaydet(@RequestBody AracDTO k) {

        try {
            return Util.islemSonucGetir(aracService.aracKaydet(k));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "guncelle", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse guncelle(@RequestBody AracDTO k) {

        try {
            return Util.islemSonucGetir(aracService.aracGuncelle(k));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "sil/{id}", method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable("id") Long id) {
        aracService.aracSil(id);
        return Util.islemSonucGetir(null);
    }
}

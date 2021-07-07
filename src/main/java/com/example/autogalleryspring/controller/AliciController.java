package com.example.autogalleryspring.controller;


import com.example.autogalleryspring.common.Util;
import com.example.autogalleryspring.dto.AliciDTO;
import com.example.autogalleryspring.dto.BaseResponse;
import com.example.autogalleryspring.entity.Abstract.BaseEntity;
import com.example.autogalleryspring.service.IAliciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RequestMapping("api/alici")
@RestController
public class AliciController extends BaseEntity {
    private IAliciService aliciService;

    @Autowired
    public AliciController(IAliciService aliciService) {
        this.aliciService = aliciService;
    }

    @RequestMapping("idye-gore-getir/{id}")
    public BaseResponse idyeGoreGetir(@PathVariable("id") Long id) {

        return Util.islemSonucGetir(aliciService.idyeGoreGetir(id));
    }

    @RequestMapping(value = "kaydet", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse kaydet(@RequestBody AliciDTO k) {

        try {
            return Util.islemSonucGetir(aliciService.aliciKaydet(k));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "guncelle", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse guncelle(@RequestBody AliciDTO k) {

        try {
            return Util.islemSonucGetir(aliciService.aliciGuncelle(k));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "sil/{id}", method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable("id") Long id) {
        aliciService.aliciSil(id);
        return Util.islemSonucGetir(null);
    }
}

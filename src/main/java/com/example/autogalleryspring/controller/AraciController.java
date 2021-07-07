package com.example.autogalleryspring.controller;

import com.example.autogalleryspring.common.Util;
import com.example.autogalleryspring.dto.AraciDTO;
import com.example.autogalleryspring.dto.BaseResponse;
import com.example.autogalleryspring.entity.Abstract.BaseEntity;
import com.example.autogalleryspring.service.IAraciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/araci")
@RestController
public class AraciController extends BaseEntity {
    private IAraciService araciService;

    @Autowired
    public AraciController(IAraciService araciService) {
        this.araciService = araciService;
    }

    @RequestMapping("idye-gore-getir/{id}")
    public BaseResponse idyeGoreGetir(@PathVariable("id") Long id) {

        return Util.islemSonucGetir(araciService.idyeGoreGetir(id));
    }

    @RequestMapping(value = "kaydet", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse kaydet(@RequestBody AraciDTO k) {

        try {
            return Util.islemSonucGetir(araciService.araciKaydet(k));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "guncelle", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse guncelle(@RequestBody AraciDTO k) {

        try {
            return Util.islemSonucGetir(araciService.araciGuncelle(k));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "sil/{id}", method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable("id") Long id) {
        araciService.araciSil(id);
        return Util.islemSonucGetir(null);
    }
}

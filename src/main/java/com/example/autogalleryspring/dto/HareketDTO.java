package com.example.autogalleryspring.dto;

import com.example.autogalleryspring.entity.Kisi;
import com.example.autogalleryspring.entity.KisiGorev;
import com.example.autogalleryspring.enums.EnumHareketTipi;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HareketDTO extends BaseDTO {
    private Calendar hareketTarihi;
    private EnumHareketTipi hareketTipi;
    private StokDTO stok;
    private List<KisiGorevDTO> kisiGorevler;




}
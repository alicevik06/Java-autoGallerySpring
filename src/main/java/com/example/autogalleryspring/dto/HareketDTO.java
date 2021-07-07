package com.example.autogalleryspring.dto;

import com.example.autogalleryspring.entity.Abstract.Kisi;
import com.example.autogalleryspring.entity.Alici;
import com.example.autogalleryspring.entity.Araci;
import com.example.autogalleryspring.entity.Satici;
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
    private List<Kisi> kisiler;
//    private AliciDTO alici;
//    private SaticiDTO satici;
//    private AraciDTO araci;


}

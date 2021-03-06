package com.example.autogalleryspring.entity;

import com.example.autogalleryspring.entity.Abstract.BaseEntity;
import com.example.autogalleryspring.enums.EnumHareketTipi;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Hareket extends BaseEntity {
    Calendar hareketTarihi;
    @Enumerated
    EnumHareketTipi hareketTipi;
    @ManyToOne
    Stok stok;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    List<KisiGorev> kisiGorevler;


    //    @ManyToOne
//    Alici alici;
//    @ManyToOne
//    Satici satici;
//    @ManyToOne
//    Araci araci;
}

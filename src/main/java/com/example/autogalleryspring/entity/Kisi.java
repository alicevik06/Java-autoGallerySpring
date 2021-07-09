package com.example.autogalleryspring.entity;


import com.example.autogalleryspring.entity.Abstract.BaseEntity;
import com.example.autogalleryspring.entity.Hareket;
import com.example.autogalleryspring.entity.KisiGorev;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.List;
@AllArgsConstructor
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "tcKimlikNo")})

public class Kisi extends BaseEntity {

    String adi;
    String soyadi;
    Calendar dogumTarihi;
    @NotNull
    String tcKimlikNo;
    @OneToMany( mappedBy = "kisi")
    List<KisiGorev> kisiGorevler;

    //    @Column(insertable = false,updatable = false)
//    Integer kisiTip;





}

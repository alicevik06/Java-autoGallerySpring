package com.example.autogalleryspring.entity;

import com.example.autogalleryspring.entity.Abstract.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Stok extends BaseEntity {
    String renk;
    Long kilometre;
    Long modelYili;
    Double fiyat;
    @ManyToOne
    Arac arac;
    @OneToMany(mappedBy = "stok")
    List<Hareket> hareketler;
}

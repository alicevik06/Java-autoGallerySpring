package com.example.autogalleryspring.entity;

import com.example.autogalleryspring.entity.Abstract.Kisi;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("1")
public class Alici extends Kisi {

    Long yas;
//    @OneToMany(mappedBy = "alici")
//    List<Hareket> hareketler;



    @ManyToMany
    List<Hareket> hareketler;

}

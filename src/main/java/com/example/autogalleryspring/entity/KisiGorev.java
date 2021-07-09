package com.example.autogalleryspring.entity;

import com.example.autogalleryspring.entity.Abstract.BaseEntity;
import com.example.autogalleryspring.enums.EnumGorev;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Entity
@Getter
@Setter
@NoArgsConstructor
public class KisiGorev extends BaseEntity {
    @ManyToOne
    Kisi kisi;
    @Enumerated
    EnumGorev gorev;
    @JsonIgnore
    @ManyToMany(mappedBy = "kisiGorevler")
    private List<Hareket> hareketler;
}

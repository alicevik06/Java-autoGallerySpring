package com.example.autogalleryspring.entity;

import com.example.autogalleryspring.entity.Abstract.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Arac extends BaseEntity {
    String Marka;
    String Model;
    @OneToMany(mappedBy = "arac")
    List<Stok> stoklar;
}

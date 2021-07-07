package com.example.autogalleryspring.dto;

import com.example.autogalleryspring.entity.Abstract.BaseEntity;
import com.example.autogalleryspring.entity.Arac;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StokDTO extends BaseDTO {

    private String renk;
    private Long kilometre;
    private Long modelYili;
    private Double fiyat;
    private AracDTO arac;
}

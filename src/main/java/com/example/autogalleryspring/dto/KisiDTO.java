package com.example.autogalleryspring.dto;

import com.example.autogalleryspring.entity.Hareket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Calendar;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public  class KisiDTO extends BaseDTO{
    private String adi;
    private String soyadi;
    private Calendar dogumTarihi;
    private String tcKimlikNo;
}

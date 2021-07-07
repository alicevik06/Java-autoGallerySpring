package com.example.autogalleryspring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Calendar;
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public abstract class KisiDTO extends BaseDTO{
    private String adi;
    private String soyadi;
    private Calendar dogumTarihi;
    private String tcKimlikNo;
    private Integer kisiTip;
}

package com.example.autogalleryspring.dto;

import com.example.autogalleryspring.enums.EnumSonucTipi;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
    EnumSonucTipi islemSonucu;
    String hata;
    Object data;
}

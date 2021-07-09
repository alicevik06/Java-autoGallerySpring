package com.example.autogalleryspring.dto;

import com.example.autogalleryspring.enums.EnumGorev;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class KisiGorevDTO extends BaseDTO {
    private KisiDTO kisi;
    private EnumGorev gorev;
}

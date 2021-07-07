package com.example.autogalleryspring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("2")
public class AraciDTO extends KisiDTO  {

    private Long kilo;
}

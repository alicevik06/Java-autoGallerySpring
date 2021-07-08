package com.example.autogalleryspring.entity.Abstract;

import com.example.autogalleryspring.entity.Abstract.BaseEntity;
import com.example.autogalleryspring.entity.Alici;
import com.example.autogalleryspring.entity.Araci;
import com.example.autogalleryspring.entity.Hareket;
import com.example.autogalleryspring.entity.Satici;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.List;
@AllArgsConstructor
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "tcKimlikNo")})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(
        use=JsonTypeInfo.Id.NAME,
        property = "kisiTip"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Alici.class, name = "1"),
        @JsonSubTypes.Type(value = Satici.class, name = "2"),
        @JsonSubTypes.Type(value = Araci.class, name = "3")
})
@DiscriminatorColumn(name="kisiTip",discriminatorType = DiscriminatorType.INTEGER)
public abstract class Kisi extends BaseEntity{

    String adi;
    String soyadi;
    Calendar dogumTarihi;
    @NotNull
    String tcKimlikNo;
    @Column(insertable = false,updatable = false)
    Integer kisiTip;
    @JsonIgnore
    @ManyToMany(mappedBy = "kisiler")
    private List<Hareket> hareketler;





}

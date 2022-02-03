package com.example.demo.entities;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@Builder
@Entity
@Table
public class Founds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "FoundId")
    Long foundId;
//    @Column(name = "FoundName")
    String foundName;
//    @Column(name = "CategoryId")
    Long categoryId;
//    @Column(name = "ItemId")
    Long itemId;
//    @Column(name = "ItemName")
    String itemName;
//    @Column(name = "MaterialId")
    Long materialId;
//    @Column(name = "FoundDescription")
    String foundDescription;
//    @Column(name = "FoundDate")
    Date foundDate;
//    @Column(name = "FoundLat")
    Double foundLat;
//    @Column(name = "FoundLng")
    Double foundLng;
//    @Column(name = "FoundImage")
    String foundImage;
//    @Column(name = "UserId")
    Long userId;
//    @Column(name = "Color1")
    Long color1;
//    @Column(name = "Color2")
    Long color2;
//    @Column(name = "Color3")
    Long color3;
//    @Column(name = "FoundAddress")
    String foundAddress;
//    @Column(name = "FoundStatus")
    Boolean foundStatus;
}
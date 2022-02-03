package com.example.demo.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Losts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "LostId")
    Long lostId;
//    @Column(name = "CategoryId")
    Long categoryId;
//    @Column(name = "ItemId")
    Long itemId;
//    @Column(name = "ItemName")
    String itemName;
//    @Column(name = "MaterialId")
    Long materialId;
//    @Column(name = "LostDescription")
    String lostDescription;
//    @Column(name = "LostDate")
    Date lostDate;
//    @Column(name = "LostLat")
    Double lostLat;
//    @Column(name = "LostLng")
    Double lostLng;
//    @Column(name = "SearchRadius")
    Long searchRadius;
//    @Column(name = "LostImage")
    String lostImage;
//    @Column(name = "UserId")
    Long userId;
//    @Column(name = "Color1")
    Long color1;
//    @Column(name = "Color2")
    Long color2;
//    @Column(name = "Color3")
    Long color3;
//    @Column(name = "LostAddress")
    String lostAddress;
//    @Column(name = "LostStatus")
    Boolean lostStatus;
}
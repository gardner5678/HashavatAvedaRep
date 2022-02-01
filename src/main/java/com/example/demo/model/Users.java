package com.example.demo.model;
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
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "UserId")
    Long userId;
//    @Column(name = "UserName")
    String userName;
//    @Column(name = "UserMail")
    String userMail;
//    @Column(name = "UserPassword")
    String userPassword;
//    @Column(name = "UserMobile")
    String userMobile;
//    @Column(name = "UserStatus")
    Boolean userStatus;
//    @Column(name = "UserImage")
    String userImage;
//    @Column(name = "UserLat")
    Double userLat;
//    @Column(name = "UserLng")
    Double userLng;
//    @Column(name = "UserAddress")
    String userAddress;
}
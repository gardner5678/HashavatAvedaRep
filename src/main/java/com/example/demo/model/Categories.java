package com.example.demo.model;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@Builder
@Table

public class Categories implements Serializable{
	private static final Long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "CategoryId")
    public Long categoryId;
//    @Column(name = "CategoryName")
    public String categoryName;
}
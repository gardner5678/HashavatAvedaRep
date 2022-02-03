package com.example.demo.entities.transportation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Route {
	int id;
	int busNumber;
	Agency agency;
	String description;
	String type;
}

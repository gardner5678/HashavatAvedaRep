package com.example.demo.entities;

public class LatLng {
	public Double Lng;
	public Double Lat;
	public Double getLng() {
		return Lng;
	}
	public void setLng(Double lng) {
		Lng = lng;
	}
	public Double getLat() {
		return Lat;
	}
	public void setLat(Double lat) {
		Lat = lat;
	}
	public LatLng(Double lng, Double lat) {
		Lng = lng;
		Lat = lat;
	}
	public LatLng() {
	}
	
	/*
        public double Lng { get; set; }
        public double Lat { get; set; }*/
}
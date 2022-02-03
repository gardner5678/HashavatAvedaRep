package com.example.demo.utility;

//import java.io.BufferedReader;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.demo.entities.transportation.Agency;
import com.example.demo.entities.transportation.Route;

public class PublicTranspotation {
	private static List<Agency> agencies = null;
	private static List<Route> routes = null;
	
	public static List<Agency> getAgencies() {
		return agencies;
	}

	public static void setAgencies(List<Agency> agencies) {
		PublicTranspotation.agencies = agencies;
	}

	public static List<Route> getRoutes() {
		return routes;
	}

	public static void setRoutes(List<Route> routes) {
		PublicTranspotation.routes = routes;
	}

	public PublicTranspotation() {
		agencies = fillAgencies();
		routes = fillRoutes();
	}
	
    private static List<Route> fillRoutes(){
    	routes = new ArrayList<Route>();
		File file = new File("src/main/java/com/example/demo/entities/transportation/routes.txt");
		String[] lines;
		try {
			lines = readFromTxt(file);
			for (int i = 1; i < lines.length; i++){
				String[] data = lines[i].split(",");
				Route route = getRouteFromStrings(data,i);
				route= removeIrrelevantCharactersFromDesc(route);
				if(routes.size()==0|| route.getDescription()!=routes.get(routes.size()-1).getDescription()) {
					routes.add(route);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return routes;
	}
	
    private static Route removeIrrelevantCharactersFromDesc(Route route){
		String str;
		str=route.getDescription().replace("[0-9#]", "");
		route.setDescription(str);
		return route;
	}
	
    private static Route getRouteFromStrings(String[] data, int id){
		Route route = new Route();
		route.setId(id);
		data[2] = data[2].replace("א","");
		data[2] = data[2].trim();
		route.setBusNumber(Integer.parseInt(data[2]));
		Long agencyId = Long.parseLong(data[1]);
		Agency agency = searchInList(agencies, agencyId);
		route.setAgency(agency);
		route.setDescription(data[3]);
		return route;
	}

	private static Agency searchInList(List<Agency> list, Long id) {
		for(Agency a : list) {
			if(a.getId() == id) {
				return a;
			}
		}
		return null;
	}
	
    private static List<Agency> fillAgencies(){
    	agencies = new ArrayList<Agency>();
		File file = new File("src/main/java/com/example/demo/entities/transportation/agencies.txt");
		String[] lines;
		try {
			lines = readFromTxt(file);
			for (int i = 1; i < lines.length; i++){
				String[] data = lines[i].split(",");
	            Agency agency = getAgencyFromStrings(data);
					agencies.add(agency);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return agencies;
    }
    
    private static Agency getAgencyFromStrings(String[] data){
        Agency agency = new Agency();
        agency.setId(Integer.parseInt(data[0]));
        agency.setName(data[1]);
        agency.setUrl(data[2]);
        return agency;
    }

	public static String[] readFromTxt(File file) throws Exception
	{
		List<String> list = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		while ((st = br.readLine()) != null){
			list.add(st);
		}
		return list.toArray(new String[0]);
	}
}

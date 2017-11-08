package GUIModule;
import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.utils.MapUtils;
import de.fhpotsdam.unfolding.providers.*;
import de.fhpotsdam.unfolding.providers.Google.*;

import java.util.List;
import java.util.Map;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;

import java.util.HashMap;
public class mapsTrial extends PApplet {
	UnfoldingMap map;
	Map<String,Float> lifeExpByCountry;
	List<Feature> countries;
	List<Marker> countryMarkers;
	Map<String, Float> lifeExpMap = new HashMap<String,Float>();
	public void setup(){
		size(800, 600, OPENGL);
		map = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
		lifeExpMap = loadLifeExpectancyFromCSV("LifeExpectancyWorldBankModule3.csv");
		println("Loaded " + lifeExpMap.size() + " data entries");//??????????????????????????????????????????????
		countries= GeoJSONReader.loadData(this, "countries.geo.json");
		countryMarkers = MapUtils.createSimpleMarkers(countries);
		map.addMarkers(countryMarkers);
		shadeCountries();
		
		
	}
	private Map<String, Float> loadLifeExpectancyFromCSV(String filename)
	{
		Map<String, Float> lifeExpMap = new HashMap<String,Float>();
		String[] rows = loadStrings(filename);
		for(String row : rows)
		{
			String[] columns = row.split(",");
			if(columns.length == 6 && !columns[5].equals("..")){
				float value = Float.parseFloat(columns[5]);
				lifeExpMap.put(columns[4],value);
			}
		}
		return lifeExpMap;
	}
	private void shadeCountries(){
		for(Marker marker: countryMarkers){
			String countryId= marker.getId();
			if(lifeExpMap.containsKey(countryId))
			{
				float lifeExp = lifeExpMap.get(countryId);
				int colourlevel = (int) map(lifeExp,40,90,10,255);
				marker.setColor(color(255-colourlevel,100,colourlevel));
			}
			else{
				marker.setColor(color(150,150,150));
			}
		}
	}
	public void draw(){
		map.draw();
		
	}

}

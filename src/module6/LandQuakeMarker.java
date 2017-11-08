package module6;

import de.fhpotsdam.unfolding.data.PointFeature;
import processing.core.PGraphics;

/** Implements a visual marker for land earthquakes on an earthquake map
 * 
 * @author UC San Diego Intermediate Software Development MOOC team
 *
 */
public class LandQuakeMarker extends EarthquakeMarker {
	
	
	public LandQuakeMarker(PointFeature quake) {
		
		// calling EarthquakeMarker constructor
		super(quake);
		
		// setting field in earthquake marker
		isOnLand = true;
	}


	@Override
	public void drawEarthquake(PGraphics pg, float x, float y) {
		// IMPLEMENT: drawing circle for LandQuake
		// DO NOT set the fill color.  That will be set in the EarthquakeMarker
		// class to indicate the depth of the earthquake.
		// Simply draw a centered square.
		// HINT: Notice the radius variable in the EarthquakeMarker class
		// and how it is set in the EarthquakeMarker constructor
		//pg.ellipse(x, y, 2*radius, 2*radius);
	    pg.pushStyle();
	    pg.noStroke();
	    
		  if(getDepth()<70)
			  pg.fill(255, 255, 0, 100);
		  if(getDepth()>70&&getDepth()<300)
			  pg.fill(0,0,255,100);
		  if(getDepth()>300)
			  pg.fill(255,0, 0, 100);
	    
	    //pg.fill(200, 200, 0, 100);
	    pg.ellipse(x, y, 40, 40);
	    pg.fill(255, 100);
	    pg.ellipse(x, y, 30, 30);
	    pg.popStyle();	
	}
	

	// Get the country the earthquake is in
	public String getCountry() {
		return (String) getProperty("country");
	}

		
}
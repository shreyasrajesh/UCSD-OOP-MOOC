package module6;

import de.fhpotsdam.unfolding.data.PointFeature;
import processing.core.PGraphics;

/** Implements a visual marker for ocean earthquakes on an earthquake map
 * 
 * @author UC San Diego Intermediate Software Development MOOC team
 *
 */
public class OceanQuakeMarker extends EarthquakeMarker {
	
	public OceanQuakeMarker(PointFeature quake) {
		super(quake);
		
		// setting field in earthquake marker
		isOnLand = false;
	}
	

	@Override
	public void drawEarthquake(PGraphics pg, float x, float y) {
		//IMPLEMENT: drawing centered square for Ocean earthquakes
		// DO NOT set the fill color.  That will be set in the EarthquakeMarker
		// class to indicate the depth of the earthquake.
		// Simply draw a centered square.
		// HINT: Notice the radius variable in the EarthquakeMarker class
		// and how it is set in the EarthquakeMarker constructor
		  pg.strokeWeight(10);
		  if(getDepth()<70)
			  pg.stroke(255, 255, 0, 200);
		  if(getDepth()>70&&getDepth()<300)
			  pg.stroke(0,0,255,100);
		  if(getDepth()>300)
			  pg.stroke(255,0, 0, 100);
		  pg.noFill();
		  pg.ellipse(x,y, 15,15);
	}
	

	

}

package smartcity.accessibility.search;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.junit.Ignore;
import org.junit.Test;

import com.teamdev.jxmaps.InfoWindow;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapViewOptions;
import com.teamdev.jxmaps.Marker;
import com.teamdev.jxmaps.swing.MapView;

import smartcity.acessibility.jxMapsFunctionality.JxMapsFunctionality;

/**
 * @author Kolikant
 *
 */
public class SearchTest{
	

//	 @Ignore
	 @Test 
     public void test1(){ 
     	 MapView mapView = JxMapsFunctionality.getMapView();
         try {
			Thread.sleep(5000);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
         SearchQuery s1 = new SearchQuery("Modi'in Yehalom St, 20");
         SearchQuery s2 = new SearchQuery("Modi'in Yehalom 30");
         
         Map map = mapView.getMap();
         
         SearchQueryResult sqr1= s1.Search(mapView);
         SearchQueryResult sqr2= s2.Search(mapView);
         try {
 			Thread.sleep(5000);
 		} catch (InterruptedException e2) {
 			e2.printStackTrace();
 		}
         
         LatLng position1 = sqr1.getCoordinations().get(0).getGeometry().getLocation();
         LatLng position2 = sqr2.getCoordinations().get(0).getGeometry().getLocation();
         
         JxMapsFunctionality.putMarker(map, position1, "result1");
         JxMapsFunctionality.putMarker(map, position2, "result2");
         
         JxMapsFunctionality.openFrame(mapView, "JxMaps - Hello, World!", 16.0);
        
         

		 try {
			Thread.sleep(300000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
            
}
	

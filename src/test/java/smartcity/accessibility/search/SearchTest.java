package smartcity.accessibility.search;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.swing.MapView;

import smartcity.accessibility.mapmanagement.JxMapsFunctionality;
import smartcity.accessibility.mapmanagement.JxMapsFunctionality.extendedMapView;;

/**
 * @author Kolikant
 *
 */
public class SearchTest{
	

	 @Ignore
	 @Test 
     public void test1() throws InterruptedException{ 
     	 MapView mapView = JxMapsFunctionality.getMapView();

         SearchQuery s1 = SearchQuery.adressSearch("Modi'in Yehalom St, 20");
         SearchQuery s2 = SearchQuery.adressSearch("Modi'in Yehalom 30");
         
         JxMapsFunctionality.waitForMapReady((extendedMapView) mapView);
         
         SearchQueryResult sqr1= s1.SearchByAddress(mapView);
         SearchQueryResult sqr2= s2.SearchByAddress(mapView);
         
         s1.waitOnSearch();
         s2.waitOnSearch();
         
         LatLng position1 = sqr1.getCoordinations().get(0).getGeometry().getLocation();
         LatLng position2 = sqr2.getCoordinations().get(0).getGeometry().getLocation();
         
         JxMapsFunctionality.putMarker((extendedMapView) mapView, position1, "result1");
         JxMapsFunctionality.putMarker((extendedMapView) mapView, position2, "result2");
         
         JxMapsFunctionality.openFrame(mapView, "JxMaps - Hello, World!", 16.0);
        
        // JxMapsFunctionality.ClearMarkers((extendedMapView) mapView);

		 try {
			Thread.sleep(300000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
	 
	 @Ignore
	 @Test
	 public void test2() throws InterruptedException{
		 MapView mapView = JxMapsFunctionality.getMapView();
		 SearchQuery s1 = SearchQuery.adressSearch("coffee shops");
		 
		 JxMapsFunctionality.waitForMapReady((extendedMapView) mapView);
         
     //    SearchQueryResult sqr1= s1.SearchByFreeText(mapView);
         
         s1.waitOnSearch();
         
      //   List<GeocoderResult> positions = sqr1.getCoordinations();
         //JxMapsFunctionality.putMarker((helper2) mapView, position1, "result1");
         
	 }
	 
	 
	 @Test 
	 public void test3() throws InterruptedException{
		 MapView mapView1 = JxMapsFunctionality.getMapView();

	        SearchQuery s1 = SearchQuery.adressSearch("Rothschild 22, Rothschild Boulevard, Tel Aviv");
	        
	        JxMapsFunctionality.waitForMapReady((extendedMapView) mapView1);
	        
	        SearchQueryResult sqr1= s1.SearchByAddress(mapView1);
	        
	        
	        s1.waitOnSearch();
	        
	        if(!sqr1.getCoordinations().isEmpty()){
		        LatLng position1 = sqr1.getCoordinations().get(0).getGeometry().getLocation();  
		        fail();
	        }else{
		        ;
	        }
	 }
	 
            
}
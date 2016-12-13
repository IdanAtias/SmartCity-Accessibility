package smartcity.accessibility.mapmanagement;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.teamdev.jxmaps.LatLng;

import smartcity.accessibility.database.ReviewManager;
import smartcity.accessibility.socialnetwork.User;
import smartcity.accessibility.socialnetwork.Review;
import smartcity.accessibility.socialnetwork.Score;

/**
 * @author Koral Chapnik
 */

public abstract class Location {

	private ArrayList<Review> reviews;
	private ArrayList<Review> pinnedReviews;	//ArthurSap

	//ArthurSap
	public ArrayList<Review> getReviews() {
		return reviews;
	}

	//ArthurSap
	public ArrayList<Review> getPinnedReviews() {
		return pinnedReviews;
	}

	public Location(){
		this.reviews = new ArrayList<Review>();
		this.pinnedReviews = new ArrayList<Review>();	// ArthurSap
	}
	
	public Score getRating(){
		return new Score(
				reviews.stream().collect(Collectors.summingInt(r -> r.getRating().getScore())) / reviews.size());
	}
	
	public abstract LatLng getCoordinates();
	
	public abstract String getAddress();
	
	/**
	 * @author Kolikant
	 */
	public void addReview(User u, int rating, String review) {
		ReviewManager.uploadReview((new Review(this, rating, review, u)), u);
	}
	
	
}

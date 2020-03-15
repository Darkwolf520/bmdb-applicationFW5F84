package bmdb;

import java.util.ArrayList;
import java.util.List;

public class User {
	public final String name;
	public final String email;
	private String password;
	private List<Review> reviewedMedia;
	
	User(String name, String email, String password){
		this.name=name;
		this.email=email;
		this.setPassword(password);
		setReviewedMedia(new ArrayList<Review>());
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Review> getReviewedMedia() {
		return reviewedMedia;
	}

	public void setReviewedMedia(List<Review> reviewedMedia) {
		this.reviewedMedia = reviewedMedia;
	}
	
	public void addReviewedMedia(Review reviewedMedia) {
		this.reviewedMedia.add(reviewedMedia);
	}
}

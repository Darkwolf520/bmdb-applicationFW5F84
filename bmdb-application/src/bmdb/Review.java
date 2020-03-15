package bmdb;

import java.io.Console;

public class Review {
	public final String text;
	private User reviewOwner;
	private Media reviewedMedia;
	public final Rating rate;
	
	Review(String text, Rating rate){
		this.text= text;
		this.rate=rate;
	}

	public User getReviewOwner() {
		return reviewOwner;
	}

	public void setReviewOwner(User reviewOwner) {
		this.reviewOwner = reviewOwner;
	}

	public Media getReviewedMedia() {
		return reviewedMedia;
	}

	public void setReviewedMedia(Media reviewedMedia) {
		this.reviewedMedia = reviewedMedia;
	}
	
	@Override
	public String toString() {
		return String.format("%s: '%s' rating=%s\n",this.reviewOwner.name, text, rate);
	}
}

package bmdb;

import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.text.DecimalFormat;



public class App {
	User user;
	Review review;
	List<Media> medias;
	Media selectedMedia;
	View view;
	Service service;
	Console c;
	
	
	public static void main(String[] args) {
		App app = new App(new View(),new Service());
		app.medias= app.service.findAllMedia();
		app.play();
		
		
		
	}
	
	public App(View view, Service service) {
		this.view = view;
		this.service = service;
		this.medias = service.findAllMedia();
	}
	
	public void play() {
		boolean again = true;
		
		this.user=view.readUserData();
		service.saveUser(this.user);
		
		while(again) {
			
			view.printMedias(medias);
			
			do {
				selectedMedia=this.returnMediaById(view.readIdFromConsole());
				if (this.selectedMedia == null) this.view.printIncorrectInput();
			} while(this.selectedMedia == null );
			
			this.doReview();
			this.service.saveReview(this.selectedMedia,this.review);
			this.printReviewAverage();
			again = view.doesUserWantAnotherReview();
		}
		view.printByeMessage();
		
	}
	
	void createUser() {
		this.service.saveUser(view.readUserData());
	}
	
	void doReview() {
		this.review = new Review(view.readNewReview(), view.newRating());
		this.review.setReviewOwner(this.user);
	}
	
	void printReviewAverage() {
		float avg = 0;
		int num = 0;
		for(Review review:selectedMedia.getReviews()) {
			avg += review.rate.valuesOfRating(review.rate);
			num++;
		}
		
		view.printAVG(avg/num);
	}
	Media returnMediaById(int id) {
		for(Media media:medias) {
			if(media.id.intValue() == id) return media;
		}
		return null;
	}
	
	
	
}

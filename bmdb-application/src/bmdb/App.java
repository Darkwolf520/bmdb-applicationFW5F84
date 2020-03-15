package bmdb;

import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.text.DecimalFormat;



public class App {
	Review review;
	List<Media> medias;
	Media selectedMedia;
	View view;
	Service service;
	Console c;
	
	
	public static void main(String[] args) {
		App app = new App(new View(),new Service());
		System.out.println("sajt");
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
		
		service.saveUser(view.readUserData());
		
		while(again) {
			
			view.printMedias(medias);
			
			do {
				selectedMedia=this.returnMediaById(view.readIdFromConsole());
				if (this.selectedMedia == null) this.view.printIncorrectInput();
			} while(this.selectedMedia == null );
			
			this.doReview();
			service.saveReview(this.selectedMedia,this.review);
			this.printReviewAverage();
			again = view.doesUserWantAnotherReview();
		}
		view.printByeMessage();
		
	}
	
	void createUser() {
		service.saveUser(view.readUserData());
	}
	
	void doReview() {
		review = new Review(view.readNewReview(), view.newRating());
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

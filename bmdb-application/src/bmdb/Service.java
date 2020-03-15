package bmdb;

import java.util.ArrayList;
import java.util.List;

public class Service {

	private List<User> users;
	private List<Media> medias;
	private List<Review> reviews;
	
	
	public Service() {
		TestData data = new TestData();
		users = data.getUsers();
		medias = data.getMedias();
		reviews = data.getReviews();
		
	}
	
	void saveUser(User user) {
		users.add(user);
	}
	
	User findUser(String name) {
		for (User user: users) {
			if(user.name == name) return user;
		}
		return null;
	}
	
	List<Media> findAllMedia(){
		return medias;
	}
	
	void saveReview(Media media, Review review) {
		media.addReviews(review);
		review.setReviewedMedia(media);
	}
	
	List<Review> findAllReview(Media media){
		return reviews;
	}
	
	User Login(String name, String password) {
		for (User user:users) {
			if(user.name==name && user.getPassword() == password ) return user; 
		}
		return null;
	}
}

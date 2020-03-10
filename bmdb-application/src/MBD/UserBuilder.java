package MBD;

import java.util.ArrayList;
import java.util.List;

public class UserBuilder implements Builder{
	private String name;
	private String email;
	private String password;
	private List<Review> reviewedMedia;
	
	UserBuilder(){
		initialise();
	}
	@Override
	public void initialise() {
		name="name";
		email="something@gmail.com";
		password="123";
		reviewedMedia=new ArrayList<Review>();
		
	}
	
	public UserBuilder setName(String name) {
		this.name=name;
		return this;
	}
	
	public UserBuilder setEmail(String email) {
		this.email=email;
		return this;
	}
	
	public UserBuilder setPassword(String password) {
		this.password=password;
		return this;
	}
	
	public UserBuilder setReviewedMedia(List<Review> reviewedMedia) {
		this.reviewedMedia=reviewedMedia;
		return this;
	}
	
	@Override
	public User build() {
		User sample = new User(name, email, password);
		sample.setReviewedMedia(reviewedMedia);
		return sample;
	}
}

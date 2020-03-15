package bmdb;

public class ReviewBuilder implements Builder {
	private String text;
	private User reviewOwner;
	private Media reviewedMedia;
	private Rating rate;
	
	ReviewBuilder(){
		initialise();
	}

	@Override
	public void initialise() {
		text= "It was fun";
		
	}
	
	public ReviewBuilder setText(String text) {
		this.text = text;
		return this;
	}
	
	public ReviewBuilder setRateToGood() {
		
		this.rate = Rating.GOOD;
		return this;
	}
	
	public ReviewBuilder setRateToAverage() {
		
		this.rate = Rating.AVERAGE;
		return this;
	}

	public ReviewBuilder setRateToBad() {
	
		this.rate = Rating.BAD;
		return this;
	}

	@Override
	public Review build() {
		Review sample = new Review(text, rate);
		return sample;
	}
}

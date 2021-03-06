package bmdb;

import java.util.HashMap;
import java.util.Map;

public enum Rating {
	BAD(1), AVERAGE(3),GOOD(5);
	public final int rate;
	private Rating(int rate) {
		this.rate=rate;
	}
	private static final Map<Rating,Integer> BY_RATE = new HashMap<Rating,Integer>();
	static {
		for(Rating r:values()) {
			BY_RATE.put(r,  r.rate);
		}
	}
	public static int valuesOfRating(Rating rating) {
		return BY_RATE.get(rating);
	}
	
	@Override
	public String toString() {
		return this.name();
	}
}

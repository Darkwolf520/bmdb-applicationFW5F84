package bmdb;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class Media {
	public final BigDecimal id;
	public final String title;
	public final String description;
	public final LocalDate premier;
	private List<Actor> cast;
	private List<Review> reviews;
	
	public Media(BigDecimal id, String title, String description, LocalDate premier) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.premier = premier;
		this.reviews=new ArrayList<Review>();
		setCast(new ArrayList<Actor>());
	}
	
	List<Actor> getCast() {
		return cast;
	}

	void setCast(List<Actor> cast) {
		this.cast = cast;
	}
	
	void addCast(Actor cast) {
		this.cast.add(cast);
	}
	
	@Override
	public String toString() {
		String out = String.format("%d:'%s' \nDescription='%s'\nPremier=%tD\nCast:\n", id.intValue(), title,
				description, premier);
		for(Actor actor:cast) {
			out += actor;
		}
		out += "Revievs:\n";
		for(Review review:reviews) {
			out += review;
		}
		return out;
	}

	public List<Review> getReviews() {
		return reviews;
	}
	
	public void addReviews(Review review) {
		this.reviews.add(review);
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
}

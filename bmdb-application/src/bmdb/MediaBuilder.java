package bmdb;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MediaBuilder implements Builder {
	
	private BigDecimal id;
	private String title;
	private String description;
	private LocalDate premier;
	private Boolean isMovie;
	private List<Actor> cast;
	
	
	MediaBuilder(){
		initialise();
	}
	
	@Override
	public void initialise() {
		title = "Film name";
		description = "A good film";
		premier = LocalDate.of(2010,01,01);
		cast=new ArrayList<Actor>();
		
	}

	public MediaBuilder setId(BigDecimal id) {
		this.id = id;
		return this;
	}
	
	public MediaBuilder setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public MediaBuilder setDescription(String description) {
		this.description = description;
		return this;
	}
	
	public MediaBuilder setPremier(LocalDate date) {
		this.premier = date;
		return this;
	}
	
	public MediaBuilder setToMovie() {
		this.isMovie = true;
		return this;
	}
	
	public MediaBuilder setToSeries() {
		this.isMovie = false;
		return this;
	}
	
	public MediaBuilder setCast(List<Actor> cast) {
		this.cast = cast;
		return this;
	}
	
	@Override
	public Media build() {
		
		if (isMovie) {
			Movie sample = new Movie(id, title, description, premier);
			sample.setCast(new ArrayList<Actor>());
			return sample;
		}
		
		Series sample = new Series(id, title, description, premier);
		sample.setCast(new ArrayList<Actor>());
		return sample;	
	}
}

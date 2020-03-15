package bmdb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ActorBuilder implements Builder {
	
	private String name;
	private LocalDate born;
	private Sex sex;
	private String biography;
	private List<Media> filmography;
	
	ActorBuilder(){
		initialise();
	}
	
	@Override
	public void initialise() {
		name = "name";
		born = LocalDate.of(2010, 01, 01);
		sex = Sex.FEMALE;
		biography = "some boring stuff here";
		filmography= new ArrayList();
	}
	
	public ActorBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public ActorBuilder setBorn(LocalDate date) {
		this.born = date;
		return this;
	}
	
	public ActorBuilder setIsFemale() {
		sex = Sex.FEMALE;
		return this;
	}
	
	public ActorBuilder setIsMale() {
		sex = Sex.MALE;
		return this;
	}
	
	public ActorBuilder setBiography(String biography) {
		this.biography = biography;
		return this;
	}
	
	public ActorBuilder setFilmography(List<Media> filmography) {
		this.filmography = filmography;
		return this;
	}
	@Override
	public Actor build() {
		Actor sample = new Actor(name, born, sex, biography);
		sample.setFilmography(new ArrayList<Media>());
		return sample;
	}
	
	

}

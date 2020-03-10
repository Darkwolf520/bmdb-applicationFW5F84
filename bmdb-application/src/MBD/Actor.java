package MBD;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Actor {
	public final String name;
	public final LocalDate born;
	public final Sex sex;
	private String biography;
	private List<Media> filmography;
	
	Actor(String name, LocalDate born, Sex sex, String biography){
		this.name=name;
		this.born = born;
		this.sex=sex;
		this.setBiography(biography);
		filmography=new ArrayList<Media>();
	}

	public List<Media> getFilmography() {
		return filmography;
	}
	
	public void setFilmography(List<Media> filmography) {
		this.filmography= filmography;
	}

	public void addFilmography(Media filmography) {
		this.filmography.add(filmography);
	}
	

	private String getBiography() {
		return biography;
	}

	private void setBiography(String biography) {
		this.biography = biography;
	}
	
	@Override
	public String toString() {	
		return String.format("name= %s, born=%tD\n", name, born);	
	}

}

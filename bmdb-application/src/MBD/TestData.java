package MBD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestData {
	private List<User> users;
	private List<Media> medias;
	private List<Review> reviews;
	private List<Actor> actors;
	UserBuilder userbuilder;
	MediaBuilder mediabuilder;
	ReviewBuilder reviewbuilder;
	ActorBuilder actorbuilder;
	
	
	TestData(){
		users=new ArrayList<User>();
		medias=new ArrayList<Media>();
		reviews=new ArrayList<Review>();
		actors=new ArrayList<Actor>();
		userbuilder = new UserBuilder();
		mediabuilder=new MediaBuilder();
		reviewbuilder= new ReviewBuilder();
		actorbuilder=new ActorBuilder();
		this.createActors();
		this.createMedias();
		this.createUsers();
		this.createReviews();
	}
	
	private void createActors() {
		actors.add(actorbuilder.setName("Chris Evans").setIsMale().setBorn(LocalDate.of(1981, 9, 13))
				.setBiography("A handsome young actor").build());
		actors.add(actorbuilder.setName("Jennifer Lawrence").setIsFemale().setBorn(LocalDate.of(1990, 8, 15))
				.setBiography("Kentucky-born actress Jennifer Lawrence began her career as a teenager").build());
		actors.add(actorbuilder.setName("Ryan Reynolds").setIsMale().setBorn(LocalDate.of(1976, 10, 23))
				.setBiography("A handsome young actor").build());
		actors.add(actorbuilder.setName("Scarlett Johasson").setIsFemale().setBorn(LocalDate.of(1984, 11, 22))
				.setBiography("Universally known as one of the sexiest women in Hollywood").build());
		actors.add(actorbuilder.setName("Vin Diesel").setIsMale().setBorn(LocalDate.of(1967, 7, 18))
				.setBiography("Actor, producer, writer, and director Vin Diesel had a charmed entry into the world of screen acting").build());
		actors.add(actorbuilder.setName("Daisy Ridley").setIsFemale().setBorn(LocalDate.of(1992, 4, 10))
				.setBiography("The fresh-faced British actress notable for her sprightly, feisty edge ").build());
		actors.add(actorbuilder.setName("Tom Cruise").setIsMale().setBorn(LocalDate.of(1962, 7, 3))
				.setBiography("An actor whose name became synonymous with all-American entertainment").build());
		actors.add(actorbuilder.setName("Dwayne Johnson").setIsMale().setBorn(LocalDate.of(1972, 3, 2))
				.setBiography("If you can smell what the Rock is cookin' then you're no doubt familiar with superstar wrestler Dwayne Johnson's swaggeringly cocky alter ego").build());
		actors.add(actorbuilder.setName("Melissa McCarthy").setIsFemale().setBorn(LocalDate.of(1970, 8, 26))
				.setBiography("First gaining notoriety as Sookie on the hit sitcom Gilmore Girls").build());
		actors.add(actorbuilder.setName("Gal Gadot").setIsFemale().setBorn(LocalDate.of(1985, 4, 30))
				.setBiography("Biography").build());	
	}
	
	private void createMedias() {
		getMedias().add(mediabuilder.setTitle("Star Wars: Episode IX - The Rise of Skywalker").setDescription("film")
				.setToMovie().setId(new BigDecimal(1)).setPremier(LocalDate.of(2019, 12, 16)).build());
		createConnectionBetweenMediasAndActors(0,5);
		createConnectionBetweenMediasAndActors(0,2);
		
		getMedias().add(mediabuilder.setTitle("The Rock").setDescription("film")
				.setToMovie().setId(new BigDecimal(2)).setPremier(LocalDate.of(2010, 11, 2)).build());
		createConnectionBetweenMediasAndActors(1,7);
		createConnectionBetweenMediasAndActors(1,4);
		
		getMedias().add(mediabuilder.setTitle("Family Guy").setDescription("random series")
				.setToSeries().setId(new BigDecimal(3)).setPremier(LocalDate.of(2012, 12, 16)).build());
		createConnectionBetweenMediasAndActors(2,2);
		createConnectionBetweenMediasAndActors(2,3);
		createConnectionBetweenMediasAndActors(2,6);
		createConnectionBetweenMediasAndActors(2,7);
		
		
		getMedias().add(mediabuilder.setTitle("Age of Ultron").setDescription("action movie")
				.setToMovie().setId(new BigDecimal(4)).setPremier(LocalDate.of(2013, 11, 15)).build());
		createConnectionBetweenMediasAndActors(3,0);
		createConnectionBetweenMediasAndActors(3,3);
		createConnectionBetweenMediasAndActors(3,9);
		
		getMedias().add(mediabuilder.setTitle("Random Love Story").setDescription("film")
				.setToMovie().setId(new BigDecimal(5)).setPremier(LocalDate.of(2008, 11, 1)).build());
		createConnectionBetweenMediasAndActors(4,6);
		createConnectionBetweenMediasAndActors(4,8);
		createConnectionBetweenMediasAndActors(4,4);
	}
	
	private void createUsers() {
		getUsers().add(userbuilder.setName("Gáspár János").setEmail("janosgaspar@gmail.com").setPassword("123").build());
		getUsers().add(userbuilder.setName("Teszt Elek").setEmail("[name]@gmail.com").setPassword("At LeAsT 8 ChArAcTer LoNg").build());
		getUsers().add(userbuilder.setName("Guest").setEmail("proba").setPassword("Guest").build());
	}
	
	private void createReviews() {
		getReviews().add(reviewbuilder.setRateToGood().setText("It was fun").build());
		this.createConnectionBetweenReviewsAndUsers(0, 1);
		this.createConnectionBetweenReviewsAndMedias(0, 2);
		getReviews().add(reviewbuilder.setRateToBad().setText("Just don't").build());
		this.createConnectionBetweenReviewsAndUsers(1, 2);
		this.createConnectionBetweenReviewsAndMedias(1, 4);
		getReviews().add(reviewbuilder.setRateToAverage().setText("Better than I expected").build());
		this.createConnectionBetweenReviewsAndUsers(2, 0);
		this.createConnectionBetweenReviewsAndMedias(2, 3);
		getReviews().add(reviewbuilder.setRateToAverage().setText("Enjoyable").build());
		this.createConnectionBetweenReviewsAndUsers(3, 2);
		this.createConnectionBetweenReviewsAndMedias(3, 1);
		getReviews().add(reviewbuilder.setRateToGood().setText("Best Movie I've ever seen").build());
		this.createConnectionBetweenReviewsAndUsers(4, 0);
		this.createConnectionBetweenReviewsAndMedias(4, 1);
		getReviews().add(reviewbuilder.setRateToBad().setText("My friend sad it was a bad one").build());
		this.createConnectionBetweenReviewsAndUsers(5, 2);
		this.createConnectionBetweenReviewsAndMedias(5, 3);
	}
	
	private void createConnectionBetweenMediasAndActors(Integer mediaindex, Integer actorindex){
		Actor actor =actors.get(actorindex);
		Media media = medias.get(mediaindex);
		
		actor.addFilmography(media);
		media.addCast(actor);
		//actors.get(actorindex).addFilmography(getMedias().get(mediaindex));
	//	getMedias().get(mediaindex).addCast(actors.get(actorindex));

	}
	
	private void createConnectionBetweenReviewsAndUsers(Integer reviewindex, Integer userindex) {
		getUsers().get(userindex).addReviewedMedia(getReviews().get(reviewindex));
		getReviews().get(reviewindex).setReviewOwner(getUsers().get(userindex));
	}
	private void createConnectionBetweenReviewsAndMedias(Integer reviewindex, Integer mediaindex) {
		getMedias().get(mediaindex).addReviews(getReviews().get(reviewindex));
		getReviews().get(reviewindex).setReviewedMedia(getMedias().get(mediaindex));
	}

	public List<User> getUsers() {
		return users;
	}

	public List<Media> getMedias() {
		return medias;
	}

	public List<Review> getReviews() {
		return reviews;
	}
}

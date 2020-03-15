package bmdb;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class View {
	
	Scanner input;
	UserBuilder builder;
	
	public View() {
		input=new Scanner(System.in);
		builder= new UserBuilder();
	}
	
	
	User readUserData() {
		System.out.println("What is your name?");
		builder.setName(input.nextLine());
		System.out.println("Type a password:");
		builder.setPassword(input.nextLine());
		System.out.println("What is your email address?");
		builder.setEmail(input.nextLine());
		return (User)builder.build();
		
	}
	
	void printWelcomeMessage(User user) {
		System.out.println("Welcome to the movie and series review application!");
	}
	
	void printByeMessage() {
		System.out.println("Have a good day!");
	}
	
	void printMedias(List<Media> medias) {
		for( Media media : medias) {
			System.out.println(media);
		}
	}
	
	void printReviews(User user) {
		for(Review review:user.getReviewedMedia()) {
			System.out.println(review);
		}
	}
	
	void printAVG(float avg) {
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("Average of reviews: "+ df.format(avg));
	}
	
	void printIncorrectInput() {
		System.out.println("Incorrect value! Please try again!");
	}
	
	String readNewReview() {
		System.out.println("Write a review");
		return input.nextLine();
	}
	
	boolean doesUserWantAnotherReview() {

		boolean exit = false;
		while(!exit) {
			exit = true;
			System.out.println("Do you want to write another review? (yes, no)");
			String in = input.nextLine();
			in = in.toLowerCase();
			if(in.equals("yes")) {
				 return Boolean.TRUE;
			}
			if(in.equals("no")) {
				 return Boolean.FALSE;
			}
			this.printIncorrectInput();
			exit=false;
		}
		return Boolean.FALSE;
	}
	
	BigDecimal readId() {
		return new BigDecimal(input.nextLine());
	}
	
	Integer readIdFromConsole() {
		System.out.println("Select an Id");
		return Integer.parseInt(input.nextLine());
	}
	
	Rating newRating() {
		boolean exit = false;
		String in;
		
		while(!exit) {
			System.out.println("Select a rating! (BAD, AVERAGE, GOOD)");
			 in = input.nextLine();
			switch(in.toLowerCase()) {
			case "good":
				return Rating.GOOD;
			case "average":
				return Rating.AVERAGE;
			case "bad":
				return Rating.BAD;
			default:
			this.printIncorrectInput();
				exit=false;
			}
		}
		return null;
		
		
	}
}

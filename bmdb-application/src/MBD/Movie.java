package MBD;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Movie extends Media{
	Movie(BigDecimal id, String title, String description, LocalDate premier){
		super(id, title, description, premier);
	}

}


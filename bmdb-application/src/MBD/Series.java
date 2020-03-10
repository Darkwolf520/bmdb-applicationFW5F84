package MBD;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Series extends Media{
	Series(BigDecimal id, String title, String description, LocalDate premier){
		super(id, title, description, premier);
	}

}

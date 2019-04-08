package datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import com.sun.jmx.snmp.Timestamp;

public class BridgesBetnAPIs {

	public static void main(String[] args) {
		Date date= new Date();
		System.out.println(date);
		Instant instant = Instant.now();
		System.out.println(instant);
		Timestamp ts = new Timestamp();
		System.out.println(ts);
		LocalDate ld = LocalDate.now();
		System.out.println(ld);

		Date date1 = Date.from(instant);
		System.out.println(date1);
		Instant instant1 = date.toInstant();
		System.out.println(instant1);
	//	date1 = Date.from(ld);
		
		//localtime and time
		
		
		
	}

}

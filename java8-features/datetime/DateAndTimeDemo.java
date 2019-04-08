package datetime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import com.sun.xml.internal.ws.policy.privateutil.LocalizationMessages;

public class DateAndTimeDemo {

	public static void main(String[] args) {
		List<Person2> people = new ArrayList<>();
		try(
				BufferedReader reader = 
					new BufferedReader(new InputStreamReader(
							DateAndTimeDemo.class.getResourceAsStream("people.txt")));
				Stream<String> stream = reader.lines();
			){
				stream.map(
						line->{
							String[] s = line.split(" ");
							String name = s[0].trim();
							int year=Integer.parseInt(s[1]);
							Month month = Month.of(Integer.parseInt(s[2]));
							int day = Integer.parseInt(s[3]);
							Person2 p = new Person2(name, LocalDate.of(year, month, day));
							people.add(p);
							return p;
						}
				).forEach(System.out::println);
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LocalDate now = LocalDate.of(2019, Month.MARCH, 25);
		people.stream().forEach(
				
				p->{
					Period period = Period.between(p.getDateOfBirth(), now);
					System.out.println(p.getName() +" was born " + period.getYears() +" years and "
							 + period.getMonths() +" months [" +p.getDateOfBirth().until(now, ChronoUnit.MONTHS)+" months]");
					
				}
				
			);
		
		LocalDate today = LocalDate.now();
		LocalDate nextSunday = today.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println("next sunday is "+nextSunday);
		System.out.println("First day of month "+today.with(TemporalAdjusters.firstDayOfMonth()));
		
		
		LocalTime todayTime = LocalTime.now();
		System.out.println(todayTime);
		LocalTime time = LocalTime.of(16, 30); //16:30
		System.out.println("time : "+time);
		
		LocalTime bedTime = LocalTime.of(23, 0);
		LocalTime wakeupTime = bedTime.plusHours(8);
		System.out.println("wakeup time : "+wakeupTime);
		
		Set<String> allZonesIds = ZoneId.getAvailableZoneIds();
		System.out.println(allZonesIds);
		ZoneId ukTZ = ZoneId.of("Europe/London");
		System.out.println(ukTZ);
		
		ZonedDateTime zonedDateTime = ZonedDateTime.of(today, time, ukTZ);
		System.out.println(zonedDateTime);
		//2019-03-25T16:30Z[Europe/London]
		
		ZonedDateTime currentMeeting = ZonedDateTime.of(2019, 8, 6, 12, 25, 00,
				0, ukTZ);
		ZonedDateTime nextMeeting = currentMeeting.plus(Period.ofMonths(12));
		
		System.out.println(nextMeeting);
		//2020-08-06T12:25+01:00[Europe/London]
		
		ZonedDateTime nextMeetingUS = nextMeeting.withZoneSameInstant(ZoneId.of("US/Central"));
		System.out.println("next meeting in us zone : "+nextMeetingUS);
		//2020-08-06T06:25-05:00[US/Central]
		
		//DateTimeFormatter
		System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(nextMeetingUS));
		//2020-08-06T06:25:00-05:00[US/Central]
		System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.format(nextMeetingUS));
		//Thu, 6 Aug 2020 06:25:00 -0500
		
	}

}
class Person2{
	private String name;
	private LocalDate dateOfBirth;
	public Person2() {
		super();
	}
	public Person2(String name, LocalDate dateOfBirth) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Person2 [name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	
}
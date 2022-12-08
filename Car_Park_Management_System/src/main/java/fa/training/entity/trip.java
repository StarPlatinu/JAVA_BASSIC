package fa.training.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class trip {
	private int tripId ;
	private String bookedTicketNumber ;
	private String carType ;
	private String departureDate ;
	private String departureTime ;
	private String destination ;
	private String driver ;
	private String maximumOnlineTicketNumber ;
}

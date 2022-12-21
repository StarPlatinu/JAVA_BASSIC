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
public class ticket {
	private int ticketId ;
	private String bookingTime ;
    private String	customerName ;
	private String licensePlate ;
	private trip trip ;
}

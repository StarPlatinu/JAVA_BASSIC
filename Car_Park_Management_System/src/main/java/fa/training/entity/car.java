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
public class car {
	private String licensePlate ;
	private String carColor ;
	private String carType ;
	private String company ;
	private parkingLot parkOb ;
}

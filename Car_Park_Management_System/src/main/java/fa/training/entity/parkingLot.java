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
public class parkingLot {
	private int parkId ;
	private double parkArea ;
	private String parkName ;
	private String parkPlace ;
	private String parkPrice ;
	private String parkStatus ;
}

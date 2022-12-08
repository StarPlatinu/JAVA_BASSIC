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
public class bookingOffice {
	private int officeId ;
	private String endContractDateline ;
	private String officeName ;
	private String officePhone ;
	private String officePlace ;
	private String officePrice ;
	private String startContractDeadline ;
	private trip tripOb ;
}

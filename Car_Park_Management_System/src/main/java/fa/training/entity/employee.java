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
public class employee {
	private int employeeId;
    private String account;
	private String department;
	private String employeeAddress;
	private String employeeBirthdate;
	private String employeeEmail;
	private String employeeName;
	private String employeePhone;
	private String password; 
	private char sex;
	private int role;
}

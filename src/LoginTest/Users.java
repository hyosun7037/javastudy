package LoginTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Users {

	private String id;
	private String pwd;
	private String name;
	private String phone;

}

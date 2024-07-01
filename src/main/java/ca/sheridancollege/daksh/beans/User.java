package ca.sheridancollege.daksh.beans;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
	
		private Long userid;
		@NonNull
		private String email;
		@NonNull
		private String encryptedpassword;
		@NonNull
		private Boolean enabled;
}



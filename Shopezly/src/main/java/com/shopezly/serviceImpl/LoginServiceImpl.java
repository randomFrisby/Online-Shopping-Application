package com.shopezly.serviceImpl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopezly.dto.LoginDTO;
import com.shopezly.exceptions.LoginException;
import com.shopezly.model.CurrentUserSession;
import com.shopezly.model.User;
import com.shopezly.repository.CurrentSessionRepo;
import com.shopezly.repository.UserRepo;
import com.shopezly.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CurrentSessionRepo currentSessionRepo;
	
	
	
	@Override
	public CurrentUserSession logIntoAccount(LoginDTO dto) throws LoginException {
		
			
		User existingUser = userRepo.findByEmail(dto.getEmail());
		
		
		if(existingUser == null)	
			throw new LoginException("No user registered with email: " + dto.getEmail());

		
		Optional<CurrentUserSession> validCustomerSessionOpt =  currentSessionRepo.findById(existingUser.getUserId());
		
		
		if(validCustomerSessionOpt.isPresent())	
			throw new LoginException("User already Logged In with this email");
		
		
		
		if(existingUser.getPassword().equals(dto.getPassword()) && existingUser.getRole() == dto.getRole()) {
			
			String key = getSaltString();
			
			CurrentUserSession currentUserSession = new CurrentUserSession(existingUser.getUserId(), key, LocalDateTime.now(), "loggedIn");
			
			currentSessionRepo.save(currentUserSession);

			return currentUserSession;
		}
		else
			throw new LoginException("Please Enter a valid password or role");
		
		
	}


	@Override
	public CurrentUserSession logOutFromAccount(String key)throws LoginException {
		
		CurrentUserSession validCustomerSession = currentSessionRepo.findByUuid(key);

		
		if(validCustomerSession == null)
			throw new LoginException("User Not Logged In with this key " + key);
		
		
		validCustomerSession.setResponse("logged out");
		currentSessionRepo.delete(validCustomerSession);

		return validCustomerSession;	
	}

	
	
	protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}

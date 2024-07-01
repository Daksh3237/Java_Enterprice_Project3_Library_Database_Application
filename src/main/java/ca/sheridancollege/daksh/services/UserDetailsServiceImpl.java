package ca.sheridancollege.daksh.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import ca.sheridancollege.daksh.database.DatabaseAccess;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private DatabaseAccess databaseAccess;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ca.sheridancollege.daksh.beans.User user = databaseAccess.findUserAccount(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        List<SimpleGrantedAuthority> authorities = databaseAccess.getRolesById(user.getUserid())
                                   .stream()
                                   .map(role -> new SimpleGrantedAuthority(role))
                                   .collect(Collectors.toList());

        return new User(user.getEmail(), user.getEncryptedpassword(), authorities);
    }
}

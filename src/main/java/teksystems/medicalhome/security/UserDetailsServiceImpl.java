package teksystems.medicalhome.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import teksystems.medicalhome.database.dao.UserDAO;
import teksystems.medicalhome.database.dao.UserRoleDAO;
import teksystems.medicalhome.database.entity.User;
import teksystems.medicalhome.database.entity.UserRole;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
//@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    public static final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

//    @Autowired
    private UserDAO userDao;

//    @Autowired
    private UserRoleDAO userRoleDao;

    @Autowired
    public UserDetailsServiceImpl(UserDAO userDao, UserRoleDAO userRoleDao) {
        this.userDao = userDao;
        this.userRoleDao = userRoleDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username '" + username + "' not found in database");
        }

        List<UserRole> userRoles = userRoleDao.findByUserId(user.getId());

        // check the account status
        boolean accountIsEnabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        // setup user roles
        Collection<? extends GrantedAuthority> springRoles = buildGrantAuthorities(userRoles);

        // gets the encrypted password from the database
        String password = user.getPassword();


        return new org.springframework.security.core.userdetails.User(username, password,
                accountIsEnabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
                springRoles);
    }


    private Collection<? extends GrantedAuthority> buildGrantAuthorities(List<UserRole> userRoles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (UserRole role : userRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getUserRole()));
        }

        return authorities;
    }

}


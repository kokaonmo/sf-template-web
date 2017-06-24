package com.exem.sf.services;

import com.exem.sf.domain.User;
import com.exem.sf.exception.UserNotFoundException;
import com.exem.sf.form.UserForm;
import com.exem.sf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

/**
 * Created by CHOI SUNG HOON on 2017. 6. 22..
 */
@Service
@Transactional
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User findUser(String username){
        User user = userRepository.findOne(username);
        if(Objects.isNull(user)){
            throw new UserNotFoundException(username);
        }
        return user;
    }

    public List<User> findUserList(){
        List<User> users = userRepository.findAll();
        return users;
    }

    public User addUser(UserForm userForm) {
        User user = new User(userForm.getUsername(), userForm.getPassword(), userForm.getFullname());
        return userRepository.save(user);
    }

    public User updateUser(String username, String password, String fullname) {
        User user = findUser(username);
        return user.update(username, password, fullname);
    }

    public User removeUser(String username) {
        User user = findUser(username);
        userRepository.delete(user);
        return user;
    }
}

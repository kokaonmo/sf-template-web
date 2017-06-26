package com.exem.sf.services;

import com.exem.sf.domain.Users;
import com.exem.sf.exception.UsersNotFoundException;
import com.exem.sf.form.UsersForm;
import com.exem.sf.repository.UsersRepository;
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
public class UsersService {
    private UsersRepository usersRepository;

    @Autowired
    public void setUserRepository(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public Users findUsers(String username){
        Users user = usersRepository.findOne(username);
        if(Objects.isNull(user)){
            throw new UsersNotFoundException(username);
        }
        return user;
    }

    public List<Users> findUsersList(){
        List<Users> users = usersRepository.findAll();
        return users;
    }

    public Users addUsers(UsersForm userForm) {
        Users user = new Users(userForm.getUsername(), userForm.getPassword(), userForm.getFullname());
        return usersRepository.save(user);
    }

    public Users updateUsers(String username, String password, String fullname) {
        Users user = findUsers(username);
        return user.update(username, password, fullname);
    }

    public Users removeUsers(String username) {
        Users user = findUsers(username);
        usersRepository.delete(user);
        return user;
    }
}

package com.exem.sf.controller;

import com.exem.sf.common.MessageSourceAccessor;
import com.exem.sf.domain.Users;
import com.exem.sf.exception.ResourceNotFoundException;
import com.exem.sf.form.UsersForm;
import com.exem.sf.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * Created by CHOI SUNG HOON on 2017. 6. 22..
 */
@RestController
@RequestMapping("/users")
public class UsersController {
    private UsersService usersService;
    private MessageSourceAccessor messageSource;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource){
        this.messageSource = new MessageSourceAccessor(messageSource);
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.HEAD })
    public ResponseEntity<List<Users>> listUsers() {
        return ResponseEntity.ok(usersService.findUsersList());
    }

    @RequestMapping(value = "/{username}/info", method = {RequestMethod.GET, RequestMethod.HEAD })
    public ResponseEntity<Users> info(@PathVariable String username){
        return ResponseEntity.ok(usersService.findUsers(username));
    }

    @RequestMapping(value = "/add", method = { RequestMethod.POST })
    public ResponseEntity<Users> addUsers(@Valid UsersForm usersForm) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usersService.addUsers(usersForm));
    }

    @RequestMapping(value = "/update/{username}", method = { RequestMethod.PUT })
    public ResponseEntity<Users> updateUsers(@PathVariable String username, String password, String fullname) {
        return ResponseEntity.ok(usersService.updateUsers(username, password, fullname));
    }

    @RequestMapping(value = "/remove/{username}", method = { RequestMethod.DELETE })
    public ResponseEntity<Users> removeUsers(@PathVariable String username) {
        return ResponseEntity.ok(usersService.removeUsers(username));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> resourceNotFoundException(ResourceNotFoundException exception, Locale locale){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", exception.getStatus());
        body.put("error", exception.getError());
        body.put("message", messageSource.getMessage(exception.getCode(), exception.getArgs(), locale).orElse("No message available"));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

}

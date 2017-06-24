package com.exem.sf.controller;

import com.exem.sf.common.MessageSourceAccessor;
import com.exem.sf.domain.User;
import com.exem.sf.exception.ResourceNotFoundException;
import com.exem.sf.form.UserForm;
import com.exem.sf.services.UserService;
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
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private MessageSourceAccessor messageSource;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource){
        this.messageSource = new MessageSourceAccessor(messageSource);
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.HEAD })
    public ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.ok(userService.findUserList());
    }

    @RequestMapping(value = "/{username}/info", method = {RequestMethod.GET, RequestMethod.HEAD })
    public ResponseEntity<User> info(@PathVariable String username){
        return ResponseEntity.ok(userService.findUser(username));
    }

    @RequestMapping(value = "/add", method = { RequestMethod.POST })
    public ResponseEntity<User> addUser(@Valid UserForm userForm) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(userForm));
    }

    @RequestMapping(value = "/update/{username}", method = { RequestMethod.PUT })
    public ResponseEntity<User> updateUser(@PathVariable String username, String password, String fullname) {
        return ResponseEntity.ok(userService.updateUser(username, password, fullname));
    }

    @RequestMapping(value = "/remove/{username}", method = { RequestMethod.DELETE })
    public ResponseEntity<User> removeUser(@PathVariable String username) {
        return ResponseEntity.ok(userService.removeUser(username));
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

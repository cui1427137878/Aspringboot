package com.tedu;

import org.springioc.Autowired;
import org.springioc.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userServiceImpl;
    public void login()
    {
        System.out.println(userServiceImpl.toString());
    }
}

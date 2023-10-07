package com.ed.tenacityxml.controller.user;

import com.ed.tenacityxml.dto.user.SoftoneUserDTO;
import com.ed.tenacityxml.service.IataPnrgovNotifRqService;
import com.ed.tenacityxml.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import java.util.Map;

@Slf4j
@RestController
@Validated
@RequestMapping("/s1-user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path="/register")
    public void post(
            @RequestBody SoftoneUserDTO softoneUser)  {
        this.userService.registerNewUser(softoneUser);
    }

}

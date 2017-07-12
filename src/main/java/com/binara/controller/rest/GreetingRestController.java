package com.binara.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by binara on 6/18/17.
 */
@RestController
public class GreetingRestController {

//    @PreAuthorize("hasRole('CUSTOMER')")
//    @PreAuthorize("#oauth2.clientHasRole('CUSTOMER')")
//    @Secured("CUSTOMER")

//    @PreAuthorize("hasAuthority('CUSTOMER')")
//    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CUSTOMER')")
    @RequestMapping(value = "/greet/", method = RequestMethod.GET)
    public ResponseEntity<String> greet(){
        return new ResponseEntity<String>("Welcome!", HttpStatus.OK);
    }
}

package com.hackathon.deliveryservice.controller;

import com.hackathon.deliveryservice.controllerwrapper.AddItemWrapper;
import com.hackathon.deliveryservice.controllerwrapper.SignUpWrapper;
import com.hackathon.deliveryservice.entities.Item;
import com.hackathon.deliveryservice.entities.UserAccount;
import com.hackathon.deliveryservice.entities.UserCard;
import com.hackathon.deliveryservice.service.ICardService;
import com.hackathon.deliveryservice.service.IItemService;
import com.hackathon.deliveryservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private ICardService cardService;
    @Autowired
    private IItemService itemService;

    @RequestMapping(path = "/signup", method = RequestMethod.POST)
    public ResponseEntity<UserAccount> signUp(@RequestBody SignUpWrapper signUpWrapper) {
        UserAccount userAccount = userService.saveUser(signUpWrapper);

        cardService.createCardForNewUser(userAccount);

        return new ResponseEntity<>(userAccount, HttpStatus.OK);
    }

    @RequestMapping(path = "/getUserByUname", method = RequestMethod.GET)
    public UserAccount getUserByUserName(@RequestParam("username") String userName) {
        UserAccount user = userService.getUserByUserName(userName);
        if (!user.isAdmin()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Only Admin Access", new Exception(""));
        }

        return user;
    }

    @RequestMapping(path = "/addItem", method = RequestMethod.POST)
    public ResponseEntity<Item> addItem(@RequestBody AddItemWrapper itemWrapper) {
        long userId = itemWrapper.getUserId();
        UserAccount userById = userService.getUserById(userId);
        if (!userById.isAdmin()) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
        Item item = itemService.addItem(itemWrapper.getItemName(), itemWrapper.getPrice());
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @RequestMapping(path = "/card", method = RequestMethod.GET)
    public UserCard viewCard(@RequestParam("userid") long userId) {
        try {
            return cardService.getCard(userId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error", new Exception(""));
        }
    }


}

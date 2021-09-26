package com.hackathon.deliveryservice.service;

import com.hackathon.deliveryservice.controllerwrapper.SignUpWrapper;
import com.hackathon.deliveryservice.dao.ILoginUserDao;
import com.hackathon.deliveryservice.dao.IUserAccountDao;
import com.hackathon.deliveryservice.dao.IUserCardDao;
import com.hackathon.deliveryservice.entities.LoginUser;
import com.hackathon.deliveryservice.entities.UserAccount;
import com.hackathon.deliveryservice.entities.UserCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private IUserAccountDao userAccountDao;
    @Autowired
    private ILoginUserDao loginUserDao;
    @Autowired
    private IUserCardDao userCardDao;


    @Override
    public void signUp(UserAccount user,
                       LoginUser loginUser) {

    }

    @Override
    public boolean login(String username,
                         String pwd) {
        return false;
    }

    @Override
    public UserAccount saveUser(SignUpWrapper signUpWrapper) {

        //create user
        UserAccount userAccount = new UserAccount();
        userAccount.setName(signUpWrapper.getName());
        userAccount.setMobileNumber(signUpWrapper.getPhNo());
        userAccount.setEmailId(signUpWrapper.getEmail());
        userAccount.setAdmin(signUpWrapper.isAdmin());
        userAccountDao.save(userAccount);

        //create login info
        LoginUser loginUser = new LoginUser();
        loginUser.setUser(userAccount);
        loginUser.setUsername(signUpWrapper.getUsername());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
        loginUser.setPassWord(bCryptPasswordEncoder.encode(signUpWrapper.getPwd()));
        loginUserDao.save(loginUser);

        //create card for the user
        UserCard userCard = new UserCard();
        userCard.setUserAccount(userAccount);
        userCard.setPoints(0);//initially 0 points
        userCardDao.save(userCard);


        return userAccount;

    }

    @Override
    public UserAccount getUserById(long userId) {
        return userAccountDao.findById(userId).orElse(null);
    }

    @Override
    public UserAccount getUserByUserName(String userName) {
        LoginUser loginInfoOfUser = loginUserDao.findLoginUserByUsername(userName);
        return loginInfoOfUser.getUser();
    }
}

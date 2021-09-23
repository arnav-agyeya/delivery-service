package com.hackathon.deliveryservice.dao;

import com.hackathon.deliveryservice.entities.UserAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAccountDaoTest {

    @Autowired
    private IUserAccountDao userAccountDao;

    @Test
    public void testInsertIntoAccount(){
//        UserAccount newUser = new UserAccount();
//        newUser.setName("U1");
//        newUser.setMobileNumber("9709888888");
//        newUser.setEmailId("abc@xyz.com");
//
//        userAccountDao.save(newUser);

        UserAccount byId = userAccountDao.getById(1L);
        System.out.println(byId);
    }

}

package com.company.test;

import com.company.dao.impl.UserDaoImpl2;
import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
public class UserDaoImpl2ITTest {

    @Autowired
    @Qualifier("userDao2")
    UserRepositoryCustom userDao;

    @Before
    public void before(){

    }

    @Test
    public void testGetAll(){
       List<User> list =  userDao.getAll(null,null,null);

        Assert.assertEquals("user size must be 1",2, list.size());
    }
}

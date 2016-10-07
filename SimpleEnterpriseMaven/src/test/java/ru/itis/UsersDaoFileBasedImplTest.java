package ru.itis;

import org.junit.Before;
import org.junit.Test;
import ru.itis.dao.UsersDaoFileBasedImpl;
import ru.itis.models.User;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by admin on 06.10.2016.
 */
public class UsersDaoFileBasedImplTest {

    private UsersDaoFileBasedImpl usersDao;

    @Before
    public void setUp() throws Exception {
        usersDao = new UsersDaoFileBasedImpl("C:\\Users\\KFU-user\\Desktop\\JavaItis\\SimpleEnterpriseMaven\\users.txt");
    }

    @Test
    public void getAll() throws Exception {
        List<User> registeredUsers = usersDao.getAll();
        int i = 0;
    }

    @Test
    public void testGet() throws Exception{
        Boolean expected = "Marsel".equals(usersDao.get(1).getName());

        assertTrue(expected);
    }

    @Test
    public void testSave()throws Exception{
        String expected = "Ainaz";

        User user = new User("Ainaz", "qwerty010", 22, 4);
        usersDao.save(user);

        String actual = usersDao.get(4).getName();

        assertEquals(expected, actual);
    }

    @Test
    public void testDelete() throws Exception{
        usersDao.delete(3);

        User expected = usersDao.get(3);

        assertNull(expected);
    }

}
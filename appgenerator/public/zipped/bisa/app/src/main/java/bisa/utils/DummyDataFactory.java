package bisa.utils;

import java.util.ArrayList;
import java.util.List;

import bisa.models.User;

/**
 * Created by bukhoriaqid on 11/27/16.
 */

public class DummyDataFactory
{
    public static List<User> createDummyUsers ()
    {
        List<User> lUser = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            lUser.add(new User(i, String.format("nama user %d", i)));
        }
        return lUser;
    }
}
package sn.isi.securiteweb.service.impl;

import sn.isi.securiteweb.dao.UserDao;
import sn.isi.securiteweb.dto.UserDto;
import sn.isi.securiteweb.entities.User;

public class UserServiceImpl {

    private UserDao userDao;

    public void register(UserDto userDto) {
        User user = new User(userDto);
        userDao.add(user);
    }
}

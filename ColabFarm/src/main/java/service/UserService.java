package service;

import dao.UserDao;
import dto.UserRequestDto;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void register(UserRequestDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setContact(dto.getContact());
        user.setEmail(dto.getEmail());
        user.setAddress(dto.getAddress());
        user.setPassword(dto.getPassword());
        user.setTypeOfUser(dto.getTypeOfUser());
        user.setCreateDate(new Timestamp(System.currentTimeMillis()));
        userDao.saveUser(user);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public boolean updateUser(int id, UserRequestDto dto) {
        User user = userDao.getUserById(id);
        if (user != null) {
            user.setName(dto.getName());
            user.setContact(dto.getContact());
            user.setEmail(dto.getEmail());
            user.setAddress(dto.getAddress());
            user.setPassword(dto.getPassword());
            user.setTypeOfUser(dto.getTypeOfUser());
            userDao.updateUser(user);
            return true;
        }
        return false;
    }

    public boolean deleteUser(int id) {
        User user = userDao.getUserById(id);
        if (user != null) {
            userDao.deleteUser(user);
            return true;
        }
        return false;
    }
}

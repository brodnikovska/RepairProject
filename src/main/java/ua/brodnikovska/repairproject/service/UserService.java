package ua.brodnikovska.repairproject.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.brodnikovska.repairproject.entity.RoleType;
import ua.brodnikovska.repairproject.entity.User;
import ua.brodnikovska.repairproject.repository.UserRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void saveNewUser(User user) {
        try {
            user.setRole(RoleType.USER);
            user.setBalance(BigDecimal.ZERO);
            userRepository.save(user);
        } catch (Exception ex){
            log.info("{Почтовый адрес уже существует}");
        }
    }


}

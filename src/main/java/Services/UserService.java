package Services;

import Entities.User;
import Repositories.UserRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
@Transactional
    public void updateUser(Long id, String newEmail){
    User user = userRepository.findById(id).orElseThrow(()->new IllegalStateException("user with id" + id + " does not exist"));
    if (newEmail != null && newEmail.length() > 0 && !Objects.equals(user.getEmail(), newEmail) && !userRepository.existsByEmail(newEmail)) {
        user.setEmail(newEmail);
    }
    else throw new IllegalStateException("user with such email already exists");
    }
}

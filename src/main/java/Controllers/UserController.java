package Controllers;

import Classes.UserPutForm;
import Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/users")
public class UserController {
    private final UserService userService;
@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PutMapping(path="{userId}")
    public void updateUser(@PathVariable("userId") Long userId
            ,@RequestBody UserPutForm userPutForm)
    {
        userService.updateUser(userId,userPutForm.getEmail());
    }
}

package lv.javaguru.java2.service.security.validator;

import lv.javaguru.java2.database.springJPA.UserRepository;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Vitolds on 11/15/2016.
 */
@Component
public class UserValidatorImpl implements UserValidator {

    @Autowired
    private UserRepository userRepository;

    private byte usernameLength = 16;
    private int emailLength = 255;

    @Override
    public ValidatorMessage validateUsername(String username) {

        if (username.length() > usernameLength)  {
            return new ValidatorMessage(false, "?username");
        }
        if (userRepository.findByUsername(username)!=null) {
            return new ValidatorMessage(false, "?username");
        }
        return new ValidatorMessage(true);
    }

    @Override
    public ValidatorMessage validateEmail(String email) {

        if (email.length() > emailLength) {
            return new ValidatorMessage(false, "?email");
        }
        if (userRepository.findByEmail(email)!=null) {
            return new ValidatorMessage(false, "?email");
        }
        if (!valEmailSynt(email)) {
            return new ValidatorMessage(false, "?email");
        }
        return new ValidatorMessage(true);
    }

    @Override
    public ValidatorMessage validatePassword(String password) {
        if (password.length() < 8) {
            return new ValidatorMessage(false, "?password");
        } else {
            return new ValidatorMessage(true);
        }
    }

    @Override
    public ValidatorMessage validateUser(User user) {
        ValidatorMessage validatorMessage;

        // Username validation
        validatorMessage = validateUsername(user.getUsername());
        if (!validatorMessage.isSuccess()) return validatorMessage;

        // Email validation
        validatorMessage = validateEmail(user.getEmail());
        if (!validatorMessage.isSuccess()) return validatorMessage;

        // Password validation
        validatorMessage = validatePassword(user.getPassword());
        if (!validatorMessage.isSuccess()) return validatorMessage;

        return new ValidatorMessage(true);
    }

    private boolean valEmailSynt(String email) {
        String[] substrs = email.split("@");
        if (substrs.length != 2) return false;
        else return true;

        // Upgrade
    }
}
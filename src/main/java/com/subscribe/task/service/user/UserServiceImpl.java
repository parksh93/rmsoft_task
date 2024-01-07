package com.subscribe.task.service.user;

import com.subscribe.task.config.jwt.TokenProvider;
import com.subscribe.task.dto.user.FindUserDTO;
import com.subscribe.task.dto.user.SaveUserDTO;
import com.subscribe.task.dto.user.SignInDTO;
import com.subscribe.task.exception.NoValidTokenException;
import com.subscribe.task.exception.NotFoundUserException;
import com.subscribe.task.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final TokenProvider tokenProvider;
    public static final Duration ACCESS_TOKEN_DURATION = Duration.ofDays(1);

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, TokenProvider tokenProvider){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public List<FindUserDTO> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(SaveUserDTO saveUserDTO) {
        String encodePassword = bCryptPasswordEncoder.encode(saveUserDTO.getPassword());
        saveUserDTO.setPassword(encodePassword);
        userRepository.save(saveUserDTO);
    }

    @Override
    public String generateToken(SignInDTO signInDTO) {
        FindUserDTO findUserDTO = userRepository.findByLoginId(signInDTO.getLoginId());

        if(findUserDTO != null) {
            if(bCryptPasswordEncoder.matches(signInDTO.getPassword(), findUserDTO.getPassword())){
                String token = tokenProvider.generateToken(findUserDTO,ACCESS_TOKEN_DURATION);

                if(!token.equals("")){
                    return token;
                }else {
                    throw new NoValidTokenException("no valid token");
                }
            }
        }

        throw new NotFoundUserException("not match");
    }
}

package com.code.auth_service.auth.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.code.auth_service.auth.dto.request.LoginDTO;
import com.code.auth_service.auth.dto.request.RegisterDTO;
import com.code.auth_service.auth.dto.response.LoginResponse;
import com.code.auth_service.auth.entity.UserVO;
import com.code.auth_service.auth.repo.AuthRepository;
import com.code.auth_service.auth.service.token.TokenService;
import com.code.auth_service.global.payload.ApiResponse;
import com.code.auth_service.security.service.UserDetailsImpl;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthRepository authrepo;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private MessageSource messageSource;

    @Override
    public ApiResponse login(LoginDTO dto) {
        var credentials = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());
        var auth = this.authenticationManager.authenticate(credentials);

        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
        String access_token = tokenService.generateToken(userDetails.getEmail());

        String message = messageSource.getMessage("login.success", null, LocaleContextHolder.getLocale());

        return new ApiResponse(true, message, new LoginResponse(access_token, null));
    }

    @Override
    public ApiResponse register(RegisterDTO dto) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.getPassword());
        UserVO userVO = new UserVO();
        userVO.setEmail(dto.getEmail());
        userVO.setUsername(dto.getName());
        userVO.setPassword(encryptedPassword);

        String message = messageSource.getMessage("register.success", null, LocaleContextHolder.getLocale());

        return new ApiResponse(true, message, authrepo.save(userVO));
    }
}

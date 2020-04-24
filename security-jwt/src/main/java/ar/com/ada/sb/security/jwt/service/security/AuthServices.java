package ar.com.ada.sb.security.jwt.service.security;

import ar.com.ada.sb.security.jwt.components.security.JwtAuthProvider;
import ar.com.ada.sb.security.jwt.model.dto.security.JwtAuthRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service("authServices")
public class AuthServices {

    @Autowired @Qualifier("jwtAuthProvider")
    private JwtAuthProvider jwtAuthProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String jwtNewToken(JwtAuthRequestBody body){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                body.getUsername(), body.getPassword()
        );

        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return jwtAuthProvider.doGenerateToken(userDetails);
    }
}

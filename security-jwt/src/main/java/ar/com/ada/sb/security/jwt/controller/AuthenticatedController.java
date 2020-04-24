package ar.com.ada.sb.security.jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/authenticated")
@PreAuthorize("authenticated")
public class AuthenticatedController {

    @GetMapping({"/ping", "/ping/"})
    public ResponseEntity testAuthenticatedToken(){
        Map<String, String> body = new HashMap<>();
        body.put("authenticated", "pong");
        return ResponseEntity.ok(body);
    }
}

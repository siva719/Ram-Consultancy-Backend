package com.example.ram.Controller;

import com.example.ram.Dto.LoginDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {

    // Hardcoded admin credentials (in-memory)
    private final String ADMIN_USERNAME = "admin";
    private final String ADMIN_PASSWORD = "admin123";

    @PostMapping("/logddhsesdjin")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDto loginDto) {
        Map<String, Object> response = new HashMap<>();

        if (ADMIN_USERNAME.equals(loginDto.getUsername()) &&
            ADMIN_PASSWORD.equals(loginDto.getPassword())) {

            response.put("success", true);
            response.put("token", "dummy-admin-token"); // you can replace with JWT later
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "Invalid username or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    // Optional: simple GET for testing in Postman
    @GetMapping
    public ResponseEntity<String> checkApi() {
        return ResponseEntity.ok("Admin API is running");
    }
}

package tech.hidetora.pdfinvoice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.hidetora.pdfinvoice.entity.User;
import tech.hidetora.pdfinvoice.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }
}

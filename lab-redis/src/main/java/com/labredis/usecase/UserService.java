package com.labredis.usecase;

import com.labredis.model.User;
import com.labredis.model.UserRequest;
import com.labredis.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @CacheEvict(cacheNames = "user", allEntries = true)
    public User save(final UserRequest userRequest) {
        log.info("Save user {}", userRequest.getName());

        User user = new User(userRequest.getName(), userRequest.getFollowers());
        return repository.save(user);
    }

    @Cacheable(cacheNames = "user")
    public List<User> getAllUsers() {
        log.info("Find all users!");
        return repository.findAll();
    }

    @Cacheable(cacheNames = "user", key="#id")
    public User findById(final Long id) {
        log.info("Find user Id {}!", id);
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User not found!"));
    }

    @CachePut(cacheNames = "user", key="#id")
    public User update(final Long id, final UserRequest userRequest) {
        User user = new User(userRequest.getName(), userRequest.getFollowers());
        user.setId(id);

        if(user.getId() == null) {
            throw new EntityNotFoundException("Identifier is empty");
        }
        log.info("Update user Id {}!", user.getId());

        return repository.save(user);
    }

    @CacheEvict(cacheNames = "user", key="#id")
    public Long delete(final Long id) {
        log.info("Delete user Id {}", id);

        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.info("User not found");
        }

        return id;
    }
}

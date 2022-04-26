package com.labredis.usecase;

import com.labredis.model.User;
import com.labredis.model.UserRequest;
import com.labredis.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private static final long USER_ID = 1L;

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository repository;

    @Mock
    private UserRequest userRequest;

    @Mock
    private User user;

    @Test
    void when_saveAnUser_then_returnSuccess() {
        when(repository.save(any())).thenReturn(user);

        assertDoesNotThrow(() -> userService.save(userRequest));
        verify(repository, times(1)).save(any());
    }

    @Test
    void when_getAllUsers_then_return_Success() {
        when(repository.findAll()).thenReturn(Collections.singletonList(user));

        assertDoesNotThrow(() -> userService.getAllUsers());
        verify(repository, times(1)).findAll();
    }

    @Test
    void when_findById_then_returnSuccess() {
        when(repository.findById(any())).thenReturn(Optional.of(user));

        assertDoesNotThrow(() -> userService.findById(USER_ID));
    }

    @Test
    void when_findById_then_returnException() {
        when(repository.findById(any())).thenThrow(new EntityNotFoundException());

        assertThrows(EntityNotFoundException.class,() -> userService.findById(USER_ID));
    }

    @Test
    void when_updateAnUser_then_returnSuccess() {
        when(repository.save(any())).thenReturn(user);

        assertDoesNotThrow(() -> userService.update(USER_ID, userRequest));
        verify(repository, times(1)).save(any());
    }

    @Test
    void when_updateAnUser_then_returnException() {
        assertThrows(EntityNotFoundException.class,() -> userService.update(null, userRequest));
    }

    @Test
    void when_deleteAnUser_then_returnSuccess() {
        doNothing().when(repository).deleteById(any());

        assertDoesNotThrow(() -> userService.delete(USER_ID));
        verify(repository, times(1)).deleteById(any());
    }

    @Test
    void when_deleteAnUser_then_returnException() {
        doThrow(EntityNotFoundException.class).when(repository).deleteById(any());

        assertThrows(EntityNotFoundException.class,() -> userService.delete(USER_ID));
    }
}
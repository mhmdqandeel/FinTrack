package com.qnadeel.springdemo.application.login;

import com.qnadeel.springdemo.core.entities.user.UserRepository;
import com.qnadeel.springdemo.core.entities.user.entity.User;
import com.qnadeel.springdemo.core.entities.user.security.PasswordEncryptor;
import com.qnadeel.springdemo.core.shared.exeption.ResourcesNotFoundException;
import com.qnadeel.springdemo.core.shared.exeption.ValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoginUseCaseTest {

    @InjectMocks
    private LoginUseCase underTest;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncryptor passwordEncryptor;

    @Test
    void user_should_login_successfully() {
        // given
        LoginCommand command = new LoginCommand("emailOrUserName", "password");

        User user = User.builder()
                .userName("name")
                .email("email")
                .password("encrypted")
                .build();

        when(userRepository.findByEmailOrUsername(eq("emailOrUserName"), eq("emailOrUserName")))
                .thenReturn(Optional.of(user));
        when(passwordEncryptor.matches("password", "encrypted")).thenReturn(true);

        // when + then
        assertDoesNotThrow(() -> {
            User result = underTest.execute(command);
            assertNotNull(result);
            assertEquals("name", result.getUserName());
            assertEquals("email", result.getEmail());
        });

        verify(userRepository).findByEmailOrUsername("emailOrUserName", "emailOrUserName");
        verify(passwordEncryptor).matches("password", "encrypted");
    }

    @Test
    void should_throw_exception_when_user_is_not_found() {
        LoginCommand command = new LoginCommand("notfound", "password");

        when(userRepository.findByEmailOrUsername("notfound", "notfound"))
                .thenReturn(Optional.empty());

        assertThrows(ResourcesNotFoundException.class, () -> {underTest.execute(command);});
    }
}
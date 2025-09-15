package com.qnadeel.springdemo.application.RegisterAccount;

import com.qnadeel.springdemo.application.user.RegisterAccount.RegisterAccountCommand;
import com.qnadeel.springdemo.application.user.RegisterAccount.RegisterAccountUseCase;
import com.qnadeel.springdemo.core.entities.user.UserFactory;
import com.qnadeel.springdemo.core.entities.user.UserRepository;
import com.qnadeel.springdemo.core.entities.user.entity.User;
import com.qnadeel.springdemo.core.shared.exeption.DuplicateResourcesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegisterAccountUseCaseTest {

    @InjectMocks
    private RegisterAccountUseCase underTest;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserFactory userFactory;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void user_should_register_account_successfully() {
        RegisterAccountCommand command =
                new RegisterAccountCommand("name", "email@email.com", "password");

        User user =User.builder()
                .userName(command.name())
                .email(command.email())
                .password(command.password())
                .build();

        when (userRepository.existsByEmail(user.getEmail())).thenReturn(false);
        when(userFactory.create(command.name(), command.email(), command.password())).thenReturn(user);
        when (userRepository.save(user)).thenReturn(user);

        assertDoesNotThrow(() -> {
            User result = underTest.execute(command);
            assertNotNull(result);
            assertEquals(command.name(), result.getUserName());
            assertEquals(command.email(), result.getEmail());
            assertEquals(command.password(), result.getPassword());
        });

        verify(userRepository).save(user);
    }

    @Test
    public void should_throw_exception() {
        RegisterAccountCommand command =
                new RegisterAccountCommand("name", "email", "password");

        when(userRepository.existsByEmail(command.email())).thenReturn(true);

        assertThrows(DuplicateResourcesException.class, () -> underTest.execute(command));

        verify(userRepository).existsByEmail(command.email());
        verify(userFactory, never()).create(command.name(), command.email(), command.password());
        verify(userRepository, never()).save(any(User.class));
    }
}
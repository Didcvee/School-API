package ru.didcvee.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.didcvee.security.entity.UserCredential;

public interface UserCredentialRepository extends JpaRepository<UserCredential, Integer> {

}

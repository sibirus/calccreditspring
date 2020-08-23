package com.calccreditspring.repository;

import com.calccreditspring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


/*Создадим репозиторий для пользователей*/
public interface UserRepo extends JpaRepository<User,Long>
{
    /*Создадим метод, который будет искать пользователей в базе*/
    User findByUsername(String username);

}

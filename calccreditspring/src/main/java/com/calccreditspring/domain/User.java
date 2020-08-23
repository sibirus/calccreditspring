package com.calccreditspring.domain;
/*Добавим возможность самостоятельной авторизации*/

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="usr")
public class User
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)/*автогенерация Id*/
    private Long id;
    private String username;
    private String password;
    private boolean active;
    /*Добавим в нашу систему таких пользователей как админ и модератор*/
    @ElementCollection(targetClass=Role.class,fetch=FetchType.EAGER)
    @CollectionTable (name="user_role",joinColumns=@JoinColumn(name="user_id" ))
    @Enumerated(EnumType.STRING)
    /*
    @Enumerated говорим , что хотим хранить Enum ввиде строки
    @CollectionTable данное поле будет храниться в отдельной таблице, таблица
    user role будет соединяться с текущей таблицей через user id
    @ElementCollection избавляет от головной боли
    по формированию таблицы для хранения Enum;
    fetch параметр, который определяет как мы будем подгружать user жадным способом
    (т.е Hibernate при соединении грузит все поля ) или
    ленивым (т.е Hibernate при соединении грузит то к чему реально обратится пользователь
    */
    private Set<Role> roles;

    //Сгенерируем геттеры и сеттеры


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

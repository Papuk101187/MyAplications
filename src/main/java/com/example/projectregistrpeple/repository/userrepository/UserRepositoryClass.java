package com.example.projectregistrpeple.repository.userrepository;

import com.example.projectregistrpeple.domain.users.Users;
import com.example.projectregistrpeple.dto.ResponseUser;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserRepositoryClass implements RepositoryInterface {


    private final SessionFactory sessionFactory;

    @Override
    public void addUser(Users users) {
        System.out.println("зашли в репозиторий добавления ");
        Session session = sessionFactory.openSession();
        session.save(users);
        System.out.println("добавили в базу данный ");
    }












}

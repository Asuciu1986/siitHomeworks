package com.alex.dam.services;

import com.alex.dam.model.Session;
import com.alex.dam.repositories.SessionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Slf4j
@Service
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;

    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }


    @Override
    public Session findByDeliveryDate(Date date) {
        return sessionRepository.findByDeliveryDate(date).orElse(null);
    }

    @Override
    public List<Session> findAll() {
        List<Session> sessions = new ArrayList<>();
        sessionRepository.findAll().forEach(sessions::add);
        return sessions;
    }

    @Override
    public Session findById(Long aLong) {
        return sessionRepository.findById(aLong).orElse(null);
    }

    @Override
    public Session save(Session object) {
        return sessionRepository.save(object);
    }

    @Override
    public void delete(Session object) {
        sessionRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        sessionRepository.deleteById(aLong);
    }
}

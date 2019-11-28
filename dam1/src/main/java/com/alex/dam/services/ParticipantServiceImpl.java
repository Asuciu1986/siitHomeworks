package com.alex.dam.services;


import com.alex.dam.model.Participant;
import com.alex.dam.repositories.ParticipantRepository;
import com.alex.dam.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository participantRepository;
    private final UserRepository userRepository;

    public ParticipantServiceImpl(ParticipantRepository participantRepository, UserRepository userRepository) {
        this.participantRepository = participantRepository;
        this.userRepository = userRepository;

    }

    @Override
    public Participant findByName(String name) {
        return participantRepository.findByName(name);
    }

    @Override
    public List<Participant> findAll() {
        List<Participant> participants = new ArrayList<>();
        participantRepository.findAll().forEach(participants::add);
        return participants;
    }

    @Override
    public Participant findById(Long aLong) {
        Optional<Participant> optionalParticipant = participantRepository.findById(aLong);
        if(optionalParticipant.isPresent()){
            return optionalParticipant.get();
        }
        else{
            return null;
        }
    }

    @Override
    public Participant save(Participant object) {
        return participantRepository.save(object);
    }

    @Override
    public void delete(Participant object) {
        participantRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        participantRepository.deleteById(aLong);
    }
}

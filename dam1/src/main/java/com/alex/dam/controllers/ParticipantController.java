package com.alex.dam.controllers;


import com.alex.dam.model.Participant;
import com.alex.dam.services.ParticipantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RequestMapping("/participants")
@Controller
public class ParticipantController {

    private static final String VIEWS_PARTICIPANT_CREATE_OR_UPDATE_FORM = "participants/createOrUpdateParticipantForm";

    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");

    }

    @RequestMapping({"/index"})
    public String listParticipants(Model model){

        model.addAttribute("participants", participantService.findAll());

        return "participants/index";
    }

    @GetMapping("/{participantId}")
    public ModelAndView showParticipant(@PathVariable Long participantId){
        ModelAndView mav = new ModelAndView("participants/participantDetails");
        mav.addObject(participantService.findById(participantId));
        return mav;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model){
        model.addAttribute("participant", Participant.builder().build());
        return VIEWS_PARTICIPANT_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Participant participant,BindingResult result){
        if(result.hasErrors()){
            return VIEWS_PARTICIPANT_CREATE_OR_UPDATE_FORM;
        }
        else{
            Participant savedParticipant = participantService.save(participant);
            return "redirect:/participants/" + savedParticipant.getId();
        }
    }

    @GetMapping("/{participantId}/edit")
    public String initUpdateParticipantForm(@PathVariable Long participantId, Model model){
        model.addAttribute(participantService.findById(participantId));
        return VIEWS_PARTICIPANT_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{participantId}/edit")
    public String processUpdateCreationForm(@Valid Participant participant, BindingResult result, @PathVariable Long participantId){
        if(result.hasErrors()){
            return VIEWS_PARTICIPANT_CREATE_OR_UPDATE_FORM;
        }
        else{
            participant.setId(participantId);
            Participant savedParticipant = participantService.save(participant);
            return "redirect:/participant/" + savedParticipant.getId();

        }
    }


}

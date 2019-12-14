package com.alex.dam.controllers;


import com.alex.dam.model.PRE;
import com.alex.dam.services.PREService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RequestMapping("/pres")
@Controller
public class PREController {

    private static final String VIEWS_PRE_CREATE_OR_UPDATE_FORM = "/pres/createOrUpdatePREForm";
    private final PREService preService;

    public PREController(PREService preService) {
        this.preService = preService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");

    }

    @RequestMapping("/index")
    public String listParticipants(Model model){

        model.addAttribute("pres", preService.findAll());

        return "pres/index";
    }

    @GetMapping("/new")
    public String initCreationForm(Model model){
        PRE pre = new PRE();
        model.addAttribute("preForm",pre);
        return VIEWS_PRE_CREATE_OR_UPDATE_FORM;
    }

    @GetMapping("/show/{preId}")
    public ModelAndView showPRE(@PathVariable Long preId){
        ModelAndView mav=new ModelAndView("/pres/presDetails");
        mav.addObject("details",preService.findById(preId));
        return mav;
    }

    @PostMapping("/new")
    public String processCreationForm(@ModelAttribute PRE pre, BindingResult result){
        if(result.hasErrors()){
            System.out.println("la erori");
            return "pres/index";
        }
        else{
            PRE savedPRE = preService.save(pre);
            System.out.println("dupa salvare");
            return "redirect:/pres/show/" + savedPRE.getId();
        }
    }


    @GetMapping("/{preId}/edit")
    public String initUpdateParticipantForm(@PathVariable Long preId, Model model){
        model.addAttribute(preService.findById(preId));
        return VIEWS_PRE_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{preId}/edit")
    public String processUpdateCreationForm(@Valid PRE pre, BindingResult result, @PathVariable Long preId){
        if(result.hasErrors()){
            return VIEWS_PRE_CREATE_OR_UPDATE_FORM;
        }
        else{
            pre.setId(preId);
            PRE savedPre = preService.save(pre);
            return "redirect:/participants/" + savedPre.getId();
        }
    }


}

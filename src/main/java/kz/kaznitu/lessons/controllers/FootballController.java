package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.mod.Club;
import kz.kaznitu.lessons.mod.Football;
import kz.kaznitu.lessons.repas.ClubRepas;
import kz.kaznitu.lessons.repas.FootballRepas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.management.MalformedObjectNameException;
import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.validation.Valid;

@Controller
public class FootballController {
    @Autowired
    private FootballRepas footballRepas;

    @Autowired
    private ClubRepas clubRepas;

    @RequestMapping("/football/{id}")
    public String football(@PathVariable("id")int id, Model model) {
        model.addAttribute("football", footballRepas.findById(id).get());
        model.addAttribute("clubs", clubRepas.findAll());
        return "football";
    }
    @RequestMapping(value="/footballs", method = RequestMethod.GET)
    public String footballsList(Model model) {
        model.addAttribute("footballs", footballRepas.findAll());
        return "footballs";
    }

    @RequestMapping(value = "/footballs", method = RequestMethod.POST)
    public String footballsAdd(@RequestParam String email,
                               @RequestParam String firstName, @RequestParam String lastName, Model model) {
        Football newFootball= new Football();
        newFootball.setEmail(email);
        newFootball.setFirstName(firstName);
        newFootball.setLastName(lastName);
        footballRepas.save(newFootball);

        model.addAttribute("football", newFootball);
        model.addAttribute("clubs", clubRepas.findAll());
        return "redirect:/footballs" ;
    }

    @RequestMapping(value="/Korzina", method = RequestMethod.GET)
    public String footballsList2(Model model) {
        model.addAttribute("footballs", footballRepas.findAll());
        return "Korzina";
    }

    @RequestMapping(value="/main", method = RequestMethod.GET)
    public String footballsList4(Model model) {
        model.addAttribute("footballs", footballRepas.findAll());
        return "footballs";
    }



    @RequestMapping(value="/Clubs", method = RequestMethod.GET)
    public String footballsList3(Model model) {
        model.addAttribute("footballs", footballRepas.findAll());
        return "clubs";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteAuthor(@RequestParam("id") int idd) {
        footballRepas.deleteById(idd);
        return new ModelAndView("redirect:/Korzina");
    }


    /////////
    @RequestMapping(value = "/football/{id}/clubs", method = RequestMethod.POST)
    public String footballAddClub(@PathVariable Integer id,@RequestParam Integer clubId, Model model){
        Club club= clubRepas.findById(clubId).get();
        Football football = footballRepas.findById(id).get();

        if (football != null){
            if (!football.hasClub(club)){
                football.getClubs().add(club);
            }
            footballRepas.save(football);
            model.addAttribute("football",footballRepas.findById(id).get());
            model.addAttribute("clubs", clubRepas.findAll());
            return "redirect:/football/" + football.getId();
        }

        model.addAttribute("footballs", footballRepas.findAll());
        return "redirect:/footballs";
    }
    @RequestMapping(value = "/clubs", method = RequestMethod.GET)
    public String clubsAdd(Model model){
        model.addAttribute("club", new Club());
        return "clubs";
    }
    @RequestMapping(value = "/clubs" , method = RequestMethod.POST)
    public String clubsAdd(@ModelAttribute("club") @Valid Club club, BindingResult result){

        if (result.hasErrors()){
            return "clubs";
        }
        clubRepas.save(club);
        return "redirect:/footballs";
        //return "redirect:/clubs";
    }
}
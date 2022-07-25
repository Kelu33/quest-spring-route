package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DoctorController {

    @GetMapping("/doctor/{number}")
    @ResponseBody
    public Doctor getDoctor(@PathVariable String number) {
        int nb = Integer.parseInt(number);
        if (nb == 13) {
            return new Doctor(nb, "Jodie Whittaker");
        } else if (nb < 13) {
            throw new ResponseStatusException(
                    HttpStatus.SEE_OTHER,
                    "go see another doctor :/");
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Impossible de récupérer l'incarnation" + number);
    }
}

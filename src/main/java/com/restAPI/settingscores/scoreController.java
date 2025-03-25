package com.restAPI.settingscores;

import org.springframework.web.bind.annotation.*;

import java.util.Scanner;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@RestController
@CrossOrigin
public class scoreController {

    //Static variable since DB is not being used in this Spring Boot practic
    static score currentScore = new score(30, 20, 10);

    @GetMapping("/score")
    public score getScore(){
        return currentScore;
    }

    //PutMapping to replace the whole resource using the body
    @PutMapping("/score")
    public score replaceScore(@RequestBody score newScore){
        currentScore = newScore;
        return currentScore;
    }

    @DeleteMapping("/score")
    public void deleteScore(){
        currentScore = null;
    }


    //Query method using PatchMapping to change the value of a resourse
    @PatchMapping("/score/wins")
    public score updateWins(@RequestParam(name = "new-value")int newValue){
        currentScore.wins = newValue;
        return currentScore;
    }


    //User @PathVariable to dynamically pull the path instead of a method for each path
    @GetMapping("/score/{winslossesties}")
    public int getWinsLossesTies(@PathVariable("winslossesties") String winslossesties) {
        if (winslossesties.equalsIgnoreCase("wins")) {
            return currentScore.wins;
        } else if (winslossesties.equalsIgnoreCase("losses")) {
            return currentScore.losses;
        } else if (winslossesties.equalsIgnoreCase("ties")) {
            return currentScore.ties;
        } else {
            return 404; // Not found
        }
    }


    //Method for each path
    /*
    @GetMapping("/score/wins")
    public int getWins() {
        return currentScore.wins;
    }

    @GetMapping("/score/ties")
    public int getTies() {
        return currentScore.ties;
    }

    @GetMapping("/score/losses")
    public int getLosses() {
        return currentScore.losses;
    } */

    //Using Post to add one to wins, losses, or ties
    @PostMapping("/score/{increase}")
    public int getincrease(@PathVariable("increase") String increase) {
        if (increase.equalsIgnoreCase("wins")) {
            currentScore.wins++;
            return currentScore.wins;
        } else if (increase.equalsIgnoreCase("losses")) {
            currentScore.losses++;
            return currentScore.losses;
        } else if (increase.equalsIgnoreCase("ties")) {
            currentScore.ties++;
            return currentScore.ties;
        } else {
            return 404; // Not found
        }
    }


/* @PostMapping("/score/wins")
public score inCreaseWins(){
    currentScore.wins++;
    return currentScore;
} */

    //Simple Get to return session properties
    @GetMapping("/info")
    public String getClientInfo(HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();
        HttpSession mysession = request.getSession();
        return "Client IP Address: " + clientIp +
                "\n Client Session: " + mysession;
    }

    //Simple get to return a string
    @GetMapping("/")
    public String getHealthCheck(){
        return "Java Rest API Practice.  Lets get this done!";
    }

}

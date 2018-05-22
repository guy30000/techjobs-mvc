package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {


    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String proceessSearchForm(@RequestParam String searchType, String searchTerm) {
        HashMap<String, String> cheese_n_description = new HashMap<>(); //Hashing with descriptions

        //cheese_n_description.put(cheeseName, cheese_disc); //addes to the hash
        //cheeses.add(search_type_n_term);  ///nolonger being used as lineb below
        //cheese_Discription.add(search_type_n_term);   //added this line to get desctiptions
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println(searchType + "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println(searchTerm + "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        return "search";

    }


}
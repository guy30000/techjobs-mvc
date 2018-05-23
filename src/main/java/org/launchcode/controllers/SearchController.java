package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping(value = "results", method = RequestMethod.POST)
    public String proceessSearchForm(Model model, @RequestParam String searchType, String searchTerm) {
        //ArrayList<HashMap<String, String>> jobs = JobData.findByColumnAndValue();

       // jobs = JobData.findByValue(searchTerm);
        System.out.println(searchType + "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println(searchTerm + "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        return "list";

    }


}
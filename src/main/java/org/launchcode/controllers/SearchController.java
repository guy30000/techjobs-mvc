package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results
    // Print a list of jobs
    private static void printJobs(ArrayList<HashMap<String, String>> all_Jobs) {
        if (all_Jobs.size() == 0) {
            System.out.println("No results found. Try again. ");
        }


        for (HashMap<String, String> each_job : all_Jobs) {
            System.out.println("***********");
            for (Map.Entry<String, String> job_list : each_job.entrySet()) {
                System.out.println(job_list.getKey() + ": " + job_list.getValue());
            }
            System.out.println("***********\n");

        }
    }  //end of search handler

}

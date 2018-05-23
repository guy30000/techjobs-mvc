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
@RequestMapping(value = "list")
public class ListController {

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {
        columnChoices.put("core competency", "Skill");
        columnChoices.put("employer", "Employer");
        columnChoices.put("location", "Location");
        columnChoices.put("position type", "Position Type");
        columnChoices.put("all", "All");
    }

    @RequestMapping(value = "")
    public String list(Model model) {

        model.addAttribute("columns", columnChoices);

        return "list";
    }

    @RequestMapping(value = "values")
    public String listColumnValues(Model model, @RequestParam String column) {

        if (column.equals("all")) {
            ArrayList<HashMap<String, String>> jobs = JobData.findAll();  //This is the jobs call that I need to pass into html
            model.addAttribute("title", "All Jobs");
            model.addAttribute("jobs", jobs);  //this looks like what needs to be passed to list
            //System.out.println(columnChoices + "columthingsVVVVVVVVVVVVVVVVV"); //test line
            //printJobs(JobData.findAll()); //test line. prints all like it did befor


            return ("list-jobs");
        } else {
            ArrayList<String> items = JobData.findAll(column);
            model.addAttribute("title", "All " + columnChoices.get(column) + " Values");
            model.addAttribute("column", column);
            model.addAttribute("items", items);
            System.out.println(columnChoices.get(column)+ columnChoices.get(column) + " -some of the columnsXXXXXXXXXXXXXXXXXXXX"); //test line
            return "list-column";
        }

    }

    @RequestMapping(value = "jobs")
    public String listJobsByColumnAndValue(Model model,
            @RequestParam String column, @RequestParam String value) {

        ArrayList<HashMap<String, String>> jobs = JobData.findByColumnAndValue(column, value);
        model.addAttribute("title", "Jobs with " + columnChoices.get(column) + ": " + value);
        model.addAttribute("jobs", jobs);

        return "list-jobs";


    }
    //Search function from techhobx
    /*
    private static void printJobs(ArrayList<HashMap<String, String>> all_Jobs) {
        if (all_Jobs.size() == 0) {
            System.out.println("No results found. Try again. ");
        }

        for (HashMap<String, String> each_job : all_Jobs) {
            for (Map.Entry<String, String> job_list : each_job.entrySet()) {
                System.out.println(job_list.getKey() + ": " + job_list.getValue());
            }

        }
    }   */

}

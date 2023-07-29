package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/") // This means URL's start with /demo (after Application path)
public class SurveyController {

    private SurveyRepo surveyDataRepo;

    @Autowired
    public SurveyController(SurveyRepo surveyDataRepo) {
        this.surveyDataRepo = surveyDataRepo;
    }

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public ResponseEntity<String> addSurveyData(@RequestBody Surveydata surveydata) {

        Surveydata newData = new Surveydata();
        newData.setFirstName(surveydata.firstName);
        newData.setLastName(surveydata.lastName);
        newData.setStreetAddress(surveydata.streetAddress);
        newData.setCity(surveydata.city);
        newData.setState(surveydata.state);
        newData.setZip(surveydata.zip);
        newData.setPhoneNumber(surveydata.phoneNumber);
        newData.setEmail(surveydata.email);
        newData.setDateOfSurvey(surveydata.dateOfSurvey);
        newData.setLikedMost(surveydata.likedMost);
        newData.setInterestedIn(surveydata.interestedIn);
        newData.setLikelihoodOfRecommendation(surveydata.likelihoodOfRecommendation);
        surveyDataRepo.save(newData);
        return ResponseEntity.ok("Information added Successfully");
    }

    @PostMapping(path = "/update/{surveyId}") // Map PUT Requests for updating a specific survey
    public ResponseEntity<String> updateSurveyData(@RequestBody Surveydata surveydata, @PathVariable Integer surveyId) {

        // Find the existing survey by its ID
        Optional<Surveydata> currentSurveyOptional = surveyDataRepo.findById(surveyId);

        if (currentSurveyOptional.isPresent()) {
            Surveydata currentSurvey = currentSurveyOptional.get();

            // Update the existing survey with the new data
            currentSurvey.setFirstName(surveydata.firstName);
            currentSurvey.setLastName(surveydata.lastName);
            currentSurvey.setStreetAddress(surveydata.streetAddress);
            currentSurvey.setCity(surveydata.city);
            currentSurvey.setState(surveydata.state);
            currentSurvey.setZip(surveydata.zip);
            currentSurvey.setPhoneNumber(surveydata.phoneNumber);
            currentSurvey.setEmail(surveydata.email);
            currentSurvey.setDateOfSurvey(surveydata.dateOfSurvey);
            currentSurvey.setLikedMost(surveydata.likedMost);
            currentSurvey.setInterestedIn(surveydata.interestedIn);
            currentSurvey.setLikelihoodOfRecommendation(surveydata.likelihoodOfRecommendation);

            // Save the updated survey
            surveyDataRepo.save(currentSurvey);

            return ResponseEntity.ok("Information updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/delete/{surveyId}") // Map DELETE Requests for deleting a specific survey
    public ResponseEntity<String> deleteSurveyById(@PathVariable Integer surveyId) {

        // Check if the survey exists in the database
        Optional<Surveydata> currentSurveyOptional = surveyDataRepo.findById(surveyId);

        if (currentSurveyOptional.isPresent()) {
            // If the survey exists, delete it from the database
            surveyDataRepo.deleteById(surveyId);
            return ResponseEntity.ok("Survey with ID " + surveyId + " deleted successfully.");
        } else {
            // If the survey doesn't exist, return a 404 Not Found response
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Surveydata> getSurveyData() {

        return surveyDataRepo.findAll();
    }
}

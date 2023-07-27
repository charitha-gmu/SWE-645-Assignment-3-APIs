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
@RequestMapping(path="/surveydata") // This means URL's start with /demo (after Application path)
public class SurveyController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private SurveyRepo surveyRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<String> addSurveyData (@RequestBody Surveydata surveydata) {


        Surveydata n = new Surveydata();
        n.setFirstName(surveydata.firstName);
        n.setLastName(surveydata.lastName);
        n.setStreetAddress(surveydata.streetAddress);
        n.setCity(surveydata.city);
        n.setState(surveydata.state);
        n.setZip(surveydata.zip);
        n.setPhoneNumber(surveydata.phoneNumber);
        n.setEmail(surveydata.email);
        n.setDateOfSurvey(surveydata.dateOfSurvey);
        n.setLikedMost(surveydata.likedMost);
        n.setInterestedIn(surveydata.interestedIn);
        n.setLikelihoodOfRecommendation(surveydata.likelihoodOfRecommendation);
        surveyRepository.save(n);
        return ResponseEntity.ok("Data Saved");
    }
    
    @PostMapping(path = "/update/{surveyId}") // Map PUT Requests for updating a specific survey
    public ResponseEntity<String> updateSurveyData(@RequestBody Surveydata surveydata, @PathVariable Integer surveyId) {

        // Find the existing survey by its ID
        Optional<Surveydata> existingSurveyOptional = surveyRepository.findById(surveyId);

        if (existingSurveyOptional.isPresent()) {
            Surveydata existingSurvey = existingSurveyOptional.get();

            // Update the existing survey with the new data
            existingSurvey.setFirstName(surveydata.firstName);
            existingSurvey.setLastName(surveydata.lastName);
            existingSurvey.setStreetAddress(surveydata.streetAddress);
            existingSurvey.setCity(surveydata.city);
            existingSurvey.setState(surveydata.state);
            existingSurvey.setZip(surveydata.zip);
            existingSurvey.setPhoneNumber(surveydata.phoneNumber);
            existingSurvey.setEmail(surveydata.email);
            existingSurvey.setDateOfSurvey(surveydata.dateOfSurvey);
            existingSurvey.setLikedMost(surveydata.likedMost);
            existingSurvey.setInterestedIn(surveydata.interestedIn);
            existingSurvey.setLikelihoodOfRecommendation(surveydata.likelihoodOfRecommendation);

            // Save the updated survey
            surveyRepository.save(existingSurvey);

            return ResponseEntity.ok("Data Updated");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping(path = "/delete/{surveyId}") // Map DELETE Requests for deleting a specific survey
    public ResponseEntity<String> deleteSurveyById(@PathVariable Integer surveyId) {

        // Check if the survey exists in the database
        Optional<Surveydata> existingSurveyOptional = surveyRepository.findById(surveyId);

        if (existingSurveyOptional.isPresent()) {
            // If the survey exists, delete it from the database
            surveyRepository.deleteById(surveyId);
            return ResponseEntity.ok("Survey with ID " + surveyId + " deleted.");
        } else {
            // If the survey doesn't exist, return a 404 Not Found response
            return ResponseEntity.notFound().build();
        }
    }



    @GetMapping(path="/all")
    public @ResponseBody Iterable<Surveydata> getSurveyData() {

        return surveyRepository.findAll();
    }
}

// 1.Sai Kiran Reddy Kudumula – G01413772
// 2.Sree Charitha Meka – G01410061
// 3.Sridevi Movva – G01417871
// 4.Shreyas Kaup Vijayananda – G01386269

// Surveydata file defines the model which includes all the data members / variables and member functions (getters and setters) which operate on the variables

package com.example.demo;

import jakarta.persistence.*;
 

@Entity
@Table(name = "assignment3")
public class Surveydata {

    // Data members defined below

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "first_name", nullable = false)
    public String firstName;

    @Column(name = "last_name", nullable = false)
    public String lastName;

    @Column(name = "street_address", nullable = false)
    public String streetAddress;

    @Column(name = "city", nullable = false)
    public String city;

    @Column(name = "state", nullable = false)
    public String state;

    @Column(name = "zip", nullable = false)
    public String zip;

    @Column(name = "phone_number", nullable = false)
    public String phoneNumber;

    @Column(name = "email", nullable = false)
    public String email;

    @Column(name = "date_of_survey", nullable = false)
    public String dateOfSurvey;

    @Column(name = "liked_most", nullable = false)
    public String likedMost;

    @Column(name = "interested_in", nullable = false)
    public String interestedIn;

    @Column(name = "likelihood_of_recommendation", nullable = false)
    public String likelihoodOfRecommendation;

    // Getter and setter methods defined below

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfSurvey() {
        return dateOfSurvey;
    }

    public void setDateOfSurvey(String dateOfSurvey) {
        this.dateOfSurvey = dateOfSurvey;
    }

    public String getLikedMost() {
        return likedMost;
    }

    public void setLikedMost(String likedMost) {
        this.likedMost = likedMost;
    }

    public String getInterestedIn() {
        return interestedIn;
    }

    public void setInterestedIn(String interestedIn) {
        this.interestedIn = interestedIn;
    }

    public String getLikelihoodOfRecommendation() {
        return likelihoodOfRecommendation;
    }

    public void setLikelihoodOfRecommendation(String likelihoodOfRecommendation) {
        this.likelihoodOfRecommendation = likelihoodOfRecommendation;
    }
}


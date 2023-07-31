// 1.Sai Kiran Reddy Kudumula – G01413772
// 2.Sree Charitha Meka – G01410061
// 3.Sridevi Movva – G01417871
// 4.Shreyas Kaup Vijayananda – G01386269

// SurveyRepo serves as a public interface that connects the Surveydata model file to the Amazon RDS Database, whose credentials are defined in the application.properties file

package com.example.demo;


import org.springframework.data.jpa.repository.*;


public interface SurveyRepo extends JpaRepository<Surveydata, Integer> {

}

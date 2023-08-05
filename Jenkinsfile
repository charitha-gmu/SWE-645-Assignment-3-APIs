// 1.Sai Kiran Reddy Kudumula – G01413772
// 2.Sree Charitha Meka – G01410061
// 3.Sridevi Movva – G01417871
// 4.Shreyas Kaup Vijayananda – G01386269

pipeline{
	agent any
	environment {
		DOCKERHUB_PASS = 'Cherrym_1998'
	}
	stages{
		stage("Generating the Build for SWE645 student survey"){
			steps{
				script{
					checkout scm
					sh 'rm -rf *.jar'
                    sh 'mvn clean package'
					sh 'docker login -u smeka2 -p ${DOCKERHUB_PASS}'
					sh 'docker build -t smeka2/swe-645-assignment-3-docker-image .'
				}
			}
		}
		stage("Pushing image to docker"){
			steps{
				script{
					sh 'docker push smeka2/swe-645-assignment-3-docker-image'
				}
			}
		}
		stage("Deploying to rancher"){
			steps{
				script{
				
					sh 'kubectl rollout restart deploy assignment2 -n assignments'
				}
			}
		}
	}
}

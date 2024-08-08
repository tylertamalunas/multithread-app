<strong> **DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>

# WESTERN GOVERNOR UNIVERSITY 
## D387 – ADVANCED JAVA


## A.  Create your subgroup and project in GitLab using the provided web link and the "GitLab How-To" web link by doing the following:

## B.  Modify the Landon Hotel scheduling application for localization and internationalization by doing the following:

### <t> 1.   Install the Landon Hotel scheduling application in your integrated development environment (IDE). Modify the Java classes of application to display a welcome message by doing the following:

#### a.  Build resource bundles for both English and French (languages required by Canadian law). Include a welcome message in the language resource bundles.
- created both language resource packs<br>



#### b.  Display the welcome message in both English and French by applying the resource bundles using a different thread for each language.
- created controller MessageController.java<br>
- MessageController.java, line 9-31: Added method to show message on front end with multiple threads<br>
- app.component.ts, line 30: added message variable<br>
- app.component.ts, line 35-36: added code to display the message from controller<br>
- app.component.html, line 22-25: Added div to display message on front end<br>
- created DisplayMessage.java 
- DisplayMessage.java, line 6-24: retrieve messages from the resource bundles


### 2.  Modify the front end to display the price for a reservation in currency rates for U.S. dollars ($), Canadian dollars (C$), and euros (€) on different lines.
- app.component.html, line 82-83: added 2 more prices and used currency pipe syntax to convert currencies.


### 3.  Display the time for an online live presentation held at the Landon Hotel by doing the following:
#### a.  Write a Java method to convert times between eastern time (ET), mountain time (MT), and coordinated universal time (UTC) zones.
- created TimeController.java
- TimeController.java, Lines 17-42: store a method for converting times
- app.component.ts, lines 31,40: call to controller to show timezones
- app.component.html, lines 28-31: added where to display timezones 

#### b.  Use the time zone conversion method from part B3a to display a message stating the time in all three times zones in hours and minutes for an online, live presentation held at the Landon Hotel. The times should be displayed as ET, MT, and UTC.


#### C.  Explain how you would deploy the Spring application with a Java back end and an Angular front end to cloud services and create a Dockerfile using the attached supporting document "How to Create a Docker Account" by doing the following:

### 1.  Build the Dockerfile to create a single image that includes all code, including modifications made in parts B1 to B3. Commit and push the final Dockerfile to GitLab.

### 2.  Test the Dockerfile by doing the following:

•   Create a Docker image of the current multithreaded Spring application.

•   Run the Docker image in a container and give the container a name that includes D387_[student ID].

•   Submit a screenshot capture of the running application with evidence it is running in the container.

### 3.  Describe how you would deploy the current multithreaded Spring application to the cloud. Include the name of the cloud service provider you would use.


Note: Remember to commit and push your changes to GitLab.


## D.  Demonstrate professional communication in the content and presentation of your submission.



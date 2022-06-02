# MyVehicleServiceApp
Service repair accounting application for vehicles.<br>
<b>Stack:</b> Cloud services, PostgreSQL, Kotlin, Spring Boot,Spring MVC<br>
<b>Software architecture:</b>
1. <i>Cloud side:</i> Database - PostgreSQL, API based on Spring Boot
2. <i>Desktop client:</i> Web application based on Spring MVC.
3. <i>Mobile client:</i> Android mobile application(Android 10 or above)<br>
# Change log:
# api
<b>v.0.0.2</b> is available. 1) Actuator: /health, /info; 2) Ability to work with Apache Tomcat. Min version is <b>9.0.43</b><br>
<b>v.0.3</b> is available. 1) Connection with remote database on Heroku; 2) Added JUnit tests.</b><br>
<b>v.0.4</b> is available. 1) created db objects for register process.<br>
<b>v.0.5</b> is available. 1) created all classes and methods for register process; 2) added web-service documentation in JavaDoc format 
started from v0.5<br>
<b>v.0.5.1</b> is available. 1) improved registration. Duplicate logins - not allowed.<br>
<b>v1.0</b> is available. Added encryption for subscriber's credentials. API for login and register process ready to use in production.<br>
<b>v1.1</b> is available. Added simple logging for /register endpoint.<br>
<b>v1.2</b> is available. Minor change for integration ws-mvs-login and mvs-web<br>
<b>v1.3</b> is available. Added loggin for /login and improve loggin process for /register.<br>
<b>w0.10a1.4d1.3m0.0</b> is available. Added new endpoint /restore-password to ws-mvs-login web-service.Minor change for integration ws-mvs-login and mvs-web in auth process.<br>
<b>w0.11a1.5d1.4m0.0</b> is available.Added new endpoint /change-password-send to ws-mvs-login web-service. It is main ability to change its password after logged in.<br>
<b>w0.12a1.6d1.4m0.0</b> is done. Was initialized new web-service -> ws-mvs-vehicle.

# web 
<b>v0.1</b> is available. First initialization and use SpringMVC on project.<br>
<b>v0.2</b> is available. Added simple css.<br>
<b>v0.3</b> is available. Added two forms on main.jsp.<br>
<b>v0.4</b> is available. Registration form was rebuilded and binded with ws-mvs-login API.<br>
<b>v0.5</b> is available. Authentication form was rebuilded and binded with ws-mvs-login API.<br>
<b>v0.6</b> is available. Improved CSS after changing forms in v0.5<br>
<b>v0.6.1</b> is available. Refactoring endpoints /login and /register using RestTemplate and 
              add analyze response from ws-mvs-login in auth and register process<br>
<b>v0.6.2</b> is available. Fixed minor errors with .jsp pages and web.xml files<br>
<b>v0.6.3</b> is available. Updated logging.<br>
<b>v0.7</b> is available. Improved CSS and navigation between pages.<br>
<b>v0.8</b> is available. Added form validator before send request to ws-mvs-login.<br>
<b>w0.9a1.3d1.2m0.0</b> is available. Fixed minor errors.<br>
<b>w0.10a1.4d1.3m0.0</b> is available. Added restore password functionality using Mailtrap service.<br>
<b>w0.11a1.5d1.4m0.0</b> is available. Added new user's functionality -> change password after logged in and changed web-design using Bootstrap.<br>
<b>w0.12a1.6d1.4m0.0</b> is done. Was add new web elements for new functionality which depended with vehicles and their features.
# db
<b>v1.2</b> is available. Fix idle bug in register process and added changing value about lastlogindate.<br>
<b>w0.10a1.4d1.3m0.0</b> is available. Added new function to find subscriber's password hash.<br>
<b>w0.11a1.5d1.4m0.0</b> is available. Added new function and modified some tables for handling changing password.
# mobile
# About version of application.
From next revision I decided to change version history in the project.<br>
Versions of application will be marked as example:<br>
<b>w</b> - version of web part<br>
<b>a</b> - version of API part<br>
<b>d</b> - version of DB objects<br>
<b>m</b> - version of Mobile part.<br>
Current version has version marked -> <b>w0.8a1.3d1.2m0.0</b>

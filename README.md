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
<b>v.0.5</b> is available. 1) created all classes and methods for register process; 2) added web-service documentation in JavaDoc format started from v0.5<br>
<b>v.0.5.1</b> is available. 1) improved registration. Duplicate logins - not allowed.<br>
<b>v1.0</b> is available. Added encryption for subscriber's credentials. API for login and register process ready to use in production.<br>
<b>v1.1</b> is available. Added simple logging for /register endpoint.<br>
<b>v1.2</b><is available. Minor change for integration ws-mvs-login and mvs-web<br>
# web 
v0.1 is available. First initialization and use SpringMVC on project.<br>
v0.2 is available. Added simple css.<br>
v0.3 is available. Added two forms on main.jsp.<br>
v0.4 is available. Registration form was rebuilded and binded with ws-mvs-login API.

# Wallet_ERP-Task

- To create, retrieve, update, delete virtual customer (CRUD) using:
>`JSF 2.3, primeface, spring context, spring jdbc, tomcat jdbc, mysql, glassfish 5.1.0.`

## Deploy

1. Import dumps file that you can find it in the repository.
2. Edit all TODO comment **except** comment inside the following path: `webapp/libr`
3. Make sure you have JDK 1.8.
4. By using maven deploy the project.
5. Add [glassfish 5.1.0](https://www.eclipse.org/downloads/download.php?file=/glassfish/glassfish-5.1.0.zip) to your Run/Debug configuration.
6. Then Add Web Application : Exploded "war" file of project to the Artifacts, and make sure the project have one exploded war file.
7. Now Add war file to glassfish, in intellij you can do that from deployment tab.
8. Mapping spring configuration classes, in intellij you can find it at project `structure/facets/spring/add` then add it all, also make sure there is no duplicates.
9. run it.

***Please note that the maven will take few time to get the dependencies from central repository.***
 

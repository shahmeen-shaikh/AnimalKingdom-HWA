# AnimalKingdom-HWA
## Coverage - 95.1%

This project is a fully functional site with a connected database to deal, handle, display and organise data. More specifically this project is designed for indpenedent sanctuary owners to help them display and manage all animals in their sanctaury. This was done with a veriety of different front end and back end technologies including HTML, CSS, JavaScript, Bootstrap, Springboot(java) and MYSQL. Sanctuary owners can use this system to view all animals in their sanctuary, add animals into the database with basic information like their name and genus. They can also update any animals in their database incase theres an error while inputting and finally, they can remove animals from the database entirely too. My motvation for this project was my love for animals. Considering how many endangered speicies we have, we should bring more attention to animals who share our planet with us!

## Getting started:

1.Springboot/java

2.MySQL

3.Github/Gitbash

4.Maven


## Installation

1.Create a Repo for your project in your github and copy the ssh code. Then find a location in your local files for the project local repo to go which will connect to the remote repo ( the one you created on github). Then you want to open up a terminal from that folder you created in your local files for the project. Then you need to enter git clone <ssh code> . This should clone your remote repo locally. Then you can go onto your project in spring boot and link to your project by selecting that local repo from your files. This should allow you to push your work and commit changes directly from the springboot terminal.


2. Within the resources folder which should be there bt default, you need to create 2 files. 

- application-test.properties
- application-prod.properties

within applcation-test.properties, this is the code you will need:

```
spring.h2.console.enabled=true

#Set JDBC URL
spring.datasource.url=jdbc:h2:mem:testdb

#Set username/pass
spring.datasource.username=sa
spring.datasource.password=

#Set URL for h2 console - http://localhost:8080/h2-console
spring.h2.console.path=/h2-console

#Showing hibernate SQL
spring.jpa.show-sql=true
```


within the application-prod.properties, this is the code you will need:

```
#MySQL Database Connection Information

#JDBC URL
spring.datasource.url=jdbc:mysql://localhost:3306/animalkingdom?createDatabaseIfNotExist=true

#Username/Pass
spring.datasource.username=root
spring.datasource.password=root

#DDL-Auto
spring.jpa.hibernate.ddl-auto=update

#Specify Driver
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

#Specify Dialect
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

#Initialistion Mode
spring.sql.init.mode=always

#Showing hibernate SQL
spring.jpa.show-sql=true
```

These bits of code should allow you to connect to your H2 console and also connect to your local MYSQL instance!


3.Once finished with project, make sure you put all your front-end files such as html/css/js into your local repo folder where your project is. Specifically inside your resource folder. Create a folder called 'static' and place files in there. This means you're ready to pack your project into a jar file.


4.You then need to add this into your pom.xml file:
```
<plugin>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-maven-plugin</artifactId>
</plugin>
```

5. Then you can open up your command line and run 
```
mvn clean package
```
These steps should successfully build and complie your project.

## Testing

you'll need to create a few packages and classes within src/test/java. The packages are:

- controllers
- services

Within controllers you need:
- EntityControllerIntegrationTest
- EntityControllerUnitTest

Within services you need:
- EntityServiceUnitTest

You can then start writing your tests and running them!
Here is an example of some tests:


![Screenshot 2022-08-19 at 16 15 13](https://user-images.githubusercontent.com/54635517/185651110-52c48b3c-b633-4661-9892-449f04795b3e.png)


Once done with unit testing you can test the final coverage of your project, here is an example of what that looks like:

![Screenshot 2022-08-19 at 10 40 22](https://user-images.githubusercontent.com/54635517/185651238-43d27654-adc3-4dea-a602-b13004f7baca.png)


Then you should be able to push everything to github. Also when your API is run you can type the following into your browser which should take you to your front end site:

```
localhost:8080
```

## Built with
- Maven -Dependency Management

## Versioning

GitHub

## Authors

- Shahmeen Shaikh -HWA Project- "https://github.com/shahmeen-shaikh/AnimalKingdom-HWA"


## License

This project is licensed under the MIT license


## Acknowledgments

- Massive thanks to everyone in my cohort including the trainers
- Special thanks to Emily and Anoush!
You guys helped me learn and develop my skills to a level i couldnt have reached without you!



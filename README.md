# CoC Character Sheet Generator
#### Video Demo:  <[URL HERE](https://www.youtube.com/watch?v=xXaLnMiIG2A)>
#### Description: A tool to automatically create statistics for characters in the popular roleplaying game Call of Cthulhu. Uses data to produce appropriate names, occupations and statistics either with stipulations or entirely randomly in either of the two approved methods for generating statistics (roll or standard array). Written in Kotlin and Javascript and deployed using AWS EC2 and GitHub pages.
The app uses the selected era to produce a list of countries and occupations that are available (as well as what foreign languages are available in the skills section), it then uses the country that is selected to calculate a suitable name from a JSON list of that countries most popular first and surnames by gender (or using various methods for dark age characters), and determines which of the national languages of that country is the characters primary spoken language.
Skills are also modified by era with some skills only available in specific eras and others having different default values.
Originally this project was going to be deployed in Heroku though that changed when they removed the free tier from their available options.
[Assigned Skills](src/main/kotlin/com/dan/legal/AssignedSkills.kt): Creates and updates all character skills for their occupation and hobby points regardless of method of stats generation
[Characteristics](src/main/kotlin/com/dan/legal/Characteristics.kt): Assigns main character statistics based on rolled results or a standard array of results
[Generators](src/main/kotlin/com/dan/legal/Generators.kt): Used for random generation of content when a value is left random in the front end form
[Main](src/main/kotlin/com/dan/legal/Main.kt): Main app file. Runs the application and some key functions. Contains all the post requests for interacting with the front-end along with some supporting functions to ensure data is transferred in the correct format
[Playable Character](src/main/kotlin/com/dan/legal/PlayableCharacter.kt): Template for each generated character. Triggers a number of other functions to generate or populate the correct information and ensures that there are no blanks in the necessary data
[Countries](src/main/resources/static/assets/json/countries.json): Contains all country specific data. This is then filtered down to a usable list based on the era that is selected in the front end
[Occupations](src/main/resources/static/assets/json/occupations.json): Contains all occupation specific data. This is then filtered down to a usable list based on the era that is selected in the front end
[Skills](src/main/resources/static/assets/json/skills.json): Contains all skill specific data. This is then filtered down to a usable list based on the era that is selected in the front end



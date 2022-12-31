# CoC Character Sheet Generator
#### Video Demo:  <[URL HERE](https://www.youtube.com/watch?v=xXaLnMiIG2A)>
#### Description:
A tool to automatically create statistics for characters in the popular roleplaying game Call of Cthulhu. Uses data to produce appropriate names, occupations and statistics either with stipulations or entirely randomly in either of the two approved methods for generating statistics (roll or standard array). Written in Kotlin and Javascript and deployed using AWS EC2 and GitHub pages.
The app uses the selected era to produce a list of countries and occupations that are available (as well as what foreign languages are available in the skills section), it then uses the country that is selected to calculate a suitable name from a JSON list of that countries most popular first and surnames by gender (or using various methods for dark age characters), and determines which of the national languages of that country is the characters primary spoken language.
Skills are also modified by era with some skills only available in specific eras and others having different default values.
Originally this project was going to be deployed in Heroku though that changed when they removed the free tier from their available options.

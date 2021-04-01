# Developer Guide

## Introduction

All-in-OneNUS is a Command Line Interface(CLI) application that aims to help students with their university lives. All-in-OneNUS has 4 components, Team Planner, CAP Calculator, Module Planner and Food Recommendation App. 


## Overall Design

The AllinOneNus class contains the main method of the program, which will call the run() method from the OverallParser class. From there, the user can then access the 4 components of the application, whereby inputting a number from 1-4 will call the respective classes.
![Architecture Diagram](https://user-images.githubusercontent.com/57632786/113196712-64462380-9296-11eb-8de3-9f02e0da93e9.png)
***
***
### Team Planner
***
#### Design
![TeamPlannerUMLDiagram](https://user-images.githubusercontent.com/77476414/112349123-6f7fd900-8d03-11eb-9b6b-5cebe73ed50e.jpg)

***
#### Implementation
***
***
### CAP Calculator
***
#### Design
![DesignDiagram](./capcalculatordiagrams/capcalculatorarchitecture.png)
***

#### Implementation
![ImplementationDiagram](./capcalculatordiagrams/CommandsForCapCalculator.png)

***
***
### Module Planner
***
#### Design

![moduleplannerUMLdiagram](https://github.com/fangxinjia0203/tp/blob/982ec3b4ee84e9f3f3ecf5bbe3cb8f5690627a70/src/main/java/seedu/allinonenus/moduleplanner/ModulePlanner.png)

***
#### Implementation
***
***
### Food Recommendation App
***
#### Design

![foodrecommendationUMLdiagram](https://user-images.githubusercontent.com/57632786/112334326-4c9af800-8cf6-11eb-892f-5599f927b551.png)

***
#### Implementation

***
***


## Product scope
### Target user profile:

 * Prefers using CLI apps

 * Is a student of NUS

 * Needs to manage a team
 
 * Requires more insights on the modules they are taking

 * Tend to be food savvy 


### Value proposition

* Have all the relevant student obligations and desires managed at a single location

## User Stories

| As a ... | I want to ... | So that I can ...|
|----------|---------------|------------------|
|student|enter the relevant information about my modules|calculate my predicted CAP|
|food savvy individual|view my food options|make better choices when selecting places to eat|
|team leader|view the team members at one glance|manage my team better|
|team leader|track the tasks that have been completed|ensure deliverables are completed on time|
|team leader|exclusively be able to add and delete members|ensure that the members list is updated and accurate|
|team leader|delegate tasks to my team members|distribute the work evenly|
|team member|track team members progress|ensure that I do not do a task that has already been completed|
|team member|mark a task as completed|inform my team members that the task has been completed|
|team member|view at one glance which tasks are more important|prioritise my tasks efficiently|
|student|gather more insights about modules offered|know if I stand a chance in getting that module|
{More to be added}
## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}

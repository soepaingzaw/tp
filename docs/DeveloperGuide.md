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
Architecture



![DesignDiagram](./capcalculatordiagrams/capcalculatorarchitecture.png)

The Architecture Diagram given above explains the high-level design of the CAP Calculator. Given below is a quick overview of each component.

1. UiText

* The UiText component manages interactions with the user and contains the methods to output 
to the user interface on the command line.

2. ParserForCapCalculator 
   
* The ParserForCapCalculator component sieves out all the different commands based on the user input
and passes it to CommandsForCapCalculator Component

3.  CommandsForCapCalculator


* The CommandsForCapCalculator component executes the different tasks the CapCalculator is capable of doing.
More will be elaborated in **this section**

4. ModuleList
  
* ModuleList handles computation, calculation and logic for CapCalculator


5. ModuleStorage

* The ModuleStorage component writes data to, and loads data from the hard disk

##### UiText Component

#### ParserForCapCalculator Component

#### CommandsForCapCalculator Component

![ImplementationDiagram](./capcalculatordiagrams/CommandsForCapCalculator.png)


#### ModuleStorage Component

#### ModuleList Component

***

#### Implementation

#### Add 

#### Delete

#### Edit





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

| Version  | Tool | As a ... | I want to ... | So that I can ...|
|---|---|----------|---------------|------------------|
|v1.0|CAP Calculator|student| add my modules and grades on a platform | store additional module information in a convienent place|
|v1.0|CAP Calculator|student| view my modules I am taking in the current semester | view my overall and semester CAP |
|v1.0|CAP Calculator|student|delete module data|remove erroneous inputs|
|v1.0|CAP Calculator|student|edit module data| simulate my overall and semester CAP based on academic ability|
|v1.0|CAP Calculator|student|exit CAP Calculator| use other tools in All-in-OneNUS|
|v1.0|CAP Calculator|student|request help within CAP |navigate the app better|
|v1.0|CAP Calculator|student|change the semester I am viewing|view my module data in a different semester|
|v1.0| |food savvy individual|view my food options|make better choices when selecting places to eat|
|v1.0| |team leader|view the team members at one glance|manage my team better|
|v1.0| |team leader|track the tasks that have been completed|ensure deliverables are completed on time|
|v1.0| |team leader|exclusively be able to add and delete members|ensure that the members list is updated and accurate|
|v1.0| |team leader|delegate tasks to my team members|distribute the work evenly|
|v1.0| |team member|track team members progress|ensure that I do not do a task that has already been completed|
|v1.0| |team member|mark a task as completed|inform my team members that the task has been completed|
|v1.0| |team member|view at one glance which tasks are more important|prioritise my tasks efficiently|
|v1.0| |student|gather more insights about modules offered|know if I stand a chance in getting that module|
|v2.0|CAP Calculator|student|display all my module data|view all my modules at a glance|
|v2.0|CAP Calculator|student|update my student year status|update my module data when I commence to the next semester|
|v2.0|CAP Calculator|student|know what my semester CAP has to be|achieve the desired overall CAP|


## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}

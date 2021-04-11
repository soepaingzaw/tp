# User Guide

## Introduction

All-in-OneNUS is a **desktop application for making university life easier in NUS.** 
It has 4 different tools, and is optimized for use via a Command Line Interface (CLI). 
- The TeamPlanner feature allows for quick and easy management of team members and the tasks 
  assigned to each team member. 
- The ModulePlanner feature is a module management tool to allow students gain more insights
  into the modules that they are interested in. 
- The CapCalculator feature is a calculation tool that has the ability to assign a module to 
  be non-graded during the calculation and simulate your grades to maximize your desired CAP. 
- The FoodRecommendation feature allows users to review food choices at a single glance and 
  recommends the user a food store accordingly.

##Table of Contents
  
***

* [1. Quick Start](#1quick-start)
  * [1.1 System Requirements](#11-system-requirements)
    * [1.1.1 Windows 7 and Above](#111-windows-7-and-above)
    * [1.1.2 Mac OS](#112-mac-os)

* [2. Features](#2features)
  * [2.1 How to use user guide](#21-how-to-use-user-guide)
  * [2.2 Main Menu](#22-main-menu)
  * [2.3 Team Planner](#23-team-planner)
    * [2.3.1 Outline](#231-outline)
    * [2.3.2 Add team member](#232-add-team-member-(requires-password))
    * [2.3.3 Delete team member](#233-delete-team-member-(requires-password))
    * [2.3.4 Show team](#234-show-team)
    * [2.3.5 Clear team](#235-clear-team-(requires-password))
    * [2.3.6 Show commands](#236-show-commands)
    * [2.3.7 Add a task to a team member](#237-add-a-task-to-a-team-member)
    * [2.3.8 Delete a task from a team member](#238-delete-a-task-from-a-team-member)
    * [2.3.9 Mark task as done](#239-mark-task-as-done)
    * [2.3.10 Show tasks](#2310-show-tasks)
    * [2.3.11 Quit](#2311-quit)
  * [2.4 CAP Calculator](#24-cap-calculator)
    * [2.4.1 Add](#241-add)
    * [2.4.2 Delete](#242-delete)
    * [2.4.3 List](#243-list)
    * [2.4.4 Edit](#244-edit)
    * [2.4.5 View](#245-view)
    * [2.4.6 Show](#246-show)
    * [2.4.7 Goal](#247-goal) 
    * [2.4.8 Update](#248-update)
    * [2.4.9 Exit](#249-exit)      
    * [2.4.10 Help](#2410-help)
  * [2.5 Module Planner](#25-module-planner)
    * [2.5.1 Module](#251-module)
    * [2.5.2 Student](#252-student)
    * [2.5.3 List down](#253-list-down)
    * [2.5.4 Recommendation](#254-recommendation)
    * [2.5.5 Delete student](#255-delete-student)
    * [2.5.6 Exit module planner](#256-exit-module-planner)
  * [2.6 Food Recommendation app](#26-food-recommendation-app)
    * [2.6.1 Add Food Store](#261-add-food-store)
    * [2.6.2 Delete Food Store](#262-delete-food-store)
    * [2.6.3 List Food Stores](#263-list-food-stores)
    * [2.6.4 Clear Food Stores](#264-clear-food-stores)
    * [2.6.5 Recommend Food Store](#265-recommend-food-store)
  * [3.FAQ](#3faq)
  * [4.Command Summary](#4command-summary)
  
---
## 1.Quick Start

***
#### 1.1 System Requirements
* Ensure that you have Java 11 or above installed. You can download the latest version of Java
   11 from [here](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html).


##### 1.1.1 Windows 7 and Above

1. Download the latest Jar file from [here](https://github.com/AY2021S2-CS2113T-T09-3/tp/releases).
2. Save the Jar file into your desired folder.
3. Open your windows search bar and type `cmd` to open command prompt.
4. Navigate to the folder you stored your Jar file in.
  - You can open a folder by typing `cd` followed by space then the name of your folder.
5. Once you are in the folder, enter `java -jar All-in-One-NUS.jar` to run the application.

##### 1.1.2 Mac OS

1. Download the latest Jar file from [here](https://github.com/AY2021S2-CS2113T-T09-3/tp/releases).
2. Save the Jar file into your desired folder.
3. Open the terminal by clicking on `Launchpad`, then `Utilities`, then `terminal`.
4. Navigate to the folder you stored your Jar file in.
  - You can open a folder by typing `cd` followed by space then the name of your folder.
5. Once you are in the folder, enter `java -jar All-in-One-NUS.jar` to run the application.


---
## 2.Features
***

### 2.1 How to use user guide
1. Single sentences in code blocks `like this` are meant to be written on the Command Line Interface (CLI)
2. Words that are in brackets [**Like this**] are your own personal inputs
> **IMPORTANT**: Certain features may contain similar commands. However, as long as you are in one feature while using 
> **All-in-One-NUS** just refer to that section
> 
> ***Example:***  If you are using the Team Planner refer to section 
> 

### 2.2 Main Menu

This is the first thing you will see upon opening the app. It allows you the acc  ess to the respective tools

````
Welcome to All-in-OneNUS app!
Enter 1 to access Team Planner
Enter 2 to access Cap Calculator
Enter 3 to access Module Planner
Enter 4 to access Food Recommendation app
Enter bye to exit app
````

Format: `[NUMBER]`

* Entering `1` directs you to the Team Planner
* Entering `2` directs you to the Module Planner
* Entering `3` directs you to the Cap Calculator
* Entering `4` directs you to the Food Recommendation app
* Entering `bye` enables you to exit the app 
* Below is a sample output when you type "bye" (not case-sensitive):

````
Welcome to All-in-OneNUS app!
Enter 1 to access Team Planner
Enter 2 to access Cap Calculator
Enter 3 to access Module Planner
Enter 4 to access Food Recommendation app
Enter bye to exit app
BYE
Thank you for using All-in-oneNUS, we hope to see you again!
````



***

### 2.3 Team Planner

#### 2.3.1 Outline

In the TeamPlanner interface, you will be able to add/delete team members as well as assign tasks to each
team member. The exact specifics of each command can be found in this section. 

Please take note that if you are a first time user that have not used the TeamPlanner inteface before, 
you will be required to filled in the following fields before gaining full access to the TeamPlanner interface:

- Input the name of the team leader
- Input the size of the team excluding the leader
- Input a password and re-input the password to confirm the password
- Shows the user the list of commands available

The TeamPlanner interface is a team management application that provides a team with the ability to track the
team and individual progress by providing a macroscopic overview of the team and tasks. In general, the commands
that handles the modification of the team members requires only a single line of input while the commands
that handles the modification of tasks assigned to each team member will require multiple lines of input as
you will be required to specify the team member as well as the relevant task index(As compared to keying in the
exact task, the use of a task index is simpler).

The following are the commands that are available in the TeamPlanner feature

#### 2.3.2 Add team member (Requires Password)
Adds a team member to the team

Format: `add member [member name]`

#### 2.3.3 Delete team member (Requires Password)
Deletes a team member from the team

Format: `delete member [member index]`

#### 2.3.4 Show team
Shows the current members in the team

Format: `show members`

#### 2.3.5 Clear team (Requires Password)
Clears the members in the team.
This will prompt the user to re-enter all information fields, such as
the team leader, size of the team, team members, as well as the password.

Format: `clear members`

#### 2.3.6 Show commands
Lists the commands available

Format: `help`

#### 2.3.7 Add a task to a team member
Adds a task to a team member on the team.

When the command is entered into the CLI, the following prompts will appear:
1. Member to add task to: Key in a team member on the team to assign the task to.
2. Task to be added: Key in the task to assign to the team member.
3. Priority level of the task: Key in the priority level of the task(HIGH/MED/LOW). Take note that the input has to
be capitalised.
   
Format: `add task`

#### 2.3.8 Delete a task from a team member
Deletes a task from a team member on the team

When the command is entered into the CLI, the following prompts will appear:
1. Member to delete task from: Key in the member the relevant task has been assigned to.
2. Index of task to be deleted: Key in the index of the task to be deleted. The task index can be retrieved by using 
   the show tasks command.
   
Format: `delete task`

#### 2.3.9 Mark task as done
Marks a task assigned to a team member as done

When the command is entered into the CLI, the following prompts will appear:
1. Member the task is assigned to: Key in the member the relevant task has been assigned to.
2. Index of task to be marked as done: Key in the index of the task to be marked as done. 
   The task index can be retrieved by using the show tasks command.

Format: `mark done`

#### 2.3.10 Show tasks
Displays the tasks assigned to each team member.

Format: `show tasks`

#### 2.3.11 Quit
Quits the Team Planner interface
Format: `quit`

***
### 2.4 CAP Calculator
***
In the CAP Calculator interface you will be able to:

1. Store all your module data and grades in one neat platform
2. Know what CAP you have to reach in the current semester to reach your overall CAP 
3. Be able to strategise how you will be able to maximize CAP  by exploring
    different permuations of SUing, dropping or getting a better grade for all
   your different modules in the current semester.
 ***

#### 2.4.1 Add
Adds your module data

>**IMPORTANT!**
>Do take note of the eligible grades of the modules you input:
> 
>![image](https://user-images.githubusercontent.com/77471508/114297698-bf70e500-9ae4-11eb-838c-fc9975cc228a.png)
>
> Pass/Fail Modules such as GEQ1000 are labelled as CS/CU Modules. CS (Completed Satisfactorily) if you pass
> and CU (Completed Unsatisfactorily) if you fail
> 
> If you have "S/Ued" a module indicate the grade as a S(Satisfactory)
> if you pass or U(Unsatisfactory) if you fail.
> Do keep track of the numbers of "S/Us" you use and ensure that
> the module you have "S/Ued" is eligible for the "S/U" option
> 

Format: `add [Module Code] [Grade] [MCs]`

Example:

Indicate your desired grade:
1. `add CS1231 A- 4`
   
For pass/fail modules indicate a CS or CU
2. `add GES1035 CS 4`
   
For modules you have "S/Ued" indicate an S or a U
3. `add GET1028 S 4`

***

#### 2.4.2 Delete
Delete specified module data

Format: `delete [Module code]`

Example: `delete CS1010`

***
#### 2.4.3 List
Lists your current semester's module data, CAP for your current semester
and overall CAP for Sem 1 to your current semester

Format: `list`
***
#### 2.4.4 Edit
Make edits to your grades for a module

Format: 
1. `edit [Module code]` 

2. `[new grade]`

Example: 
1. `edit CS1231`

2. `A-`

***
#### 2.4.5 View
View module and CAP information for Year a Semester b

Format: `view Y[a]S[b]`

Example: `view Y1S1`

***

#### 2.4.6 Show
Show all modules from semester 1 to your current sem

Format: `show`


***

#### 2.4.7 Goal
Simulate the CAP you should get in order to attain your desired overall CAP

>**IMPORTANT NOTE**: Please fill your current semester with modules you are currently taking

>This includes arbitrary grades and the number of MCs of the modules

Format: `goal [Desired Overall CAP]`

Example: `goal 4.5`

***

#### 2.4.8 Update
Update your current student status should you commence to the next semester

Format: `update Y[a]S[b]`

If you are going to be a year 3 sem 1 student, you will have to type:

Example: `update Y3S1`

***

#### 2.4.9 Exit
Exit CAP Calculator

Format: `exit`

***

#### 2.4.10 Help

Lists out all options available

Format: `help`

***

### 2.5 Module Planner

***

#### 2.5.1 Module
Enter the module code followed by the number of slots available.

Format: `module [module code],[slots]`


#### 2.5.2 Student
Enter the student information and the rank they want to put for bidding the module. 

Enter [true]/[false] for [graduation requirement] to indicate whether the module is required for graduation.

Format: `student [name],[year],[graduation requirement],[rank]`

#### 2.5.3 List down
Lists down the students and their priority who want to get the module. 

It is sorted in descending order by their priority score.

Format: `list`

#### 2.5.4 Recommendation
Shows the number of students who have higher priority and predicts the chances of getting that module (High, medium or low)

Format: `recommendation [name]`

#### 2.5.5 Delete student
Removes the student from the list.

Format: `delete [index]`

#### 2.5.6 Exit module planner
Exit module planner

Format: 'bye'
***
### 2.6 Food Recommendation app

#### 2.6.1 Add Food Store
Adds a food store with the desired description

Format: `add [Name], [Description]`


#### 2.6.2 Delete Food Store
Deletes a food store with the indicated index

Format: `delete [store index]`

#### 2.6.3 List Food Stores
Prints the list of food stores that are stored in the app

Format: `list`

#### 2.6.4 Clear Food Stores
Clears the entire list of food stores

Format: `clear`

#### 2.6.5 Recommend Food Store
Prints a random food store from the list to recommend to the user

Format: `recommend`

***
## 3.FAQ

**Q**: How do I transfer my data to another computer?

**A**: Copy the `.jar` file along with the `team.txt`, `Food Recommendation.txt`, `ModulePlanner.txt` and
`ModuleStorage.txt` to the destination folder.


## 4.Command Summary
***

  Features|From | Command to enter
----|-----|-------
[Enter Team Planner](#22-main-menu) | Main Menu | `1`
[Enter CAP Calculator](#22-main-menu) | Main Menu | `2`
[2.4.1 Add](#241-add) | CAP Calculator | `add [Module Code] [Grade] [MCs]`
[2.4.2 Delete](#242-delete)| CAP Calculator | `delete [Module code]`
[2.4.3 List](#243-list) | CAP Calculator | `list`
[2.4.4 Edit](#244-edit)| CAP Calculator | 1. `edit [Module code]` 2. `[new grade]`
[2.4.5 View](#245-view) | CAP Calculator | `view Y[a]S[b]`
[2.4.6 Show](#246-show)| CAP Calculator | `show`
[2.4.7 Goal](#247-goal)  | CAP Calculator | `goal`
[2.4.8 Update](#248-update) | CAP Calculator | `update Y[a]S[b]`
[2.4.9 Exit](#249-exit)  | CAP Calculator | `exit`
[2.4.10 Help](#2410-help) | CAP Calculator | `help`
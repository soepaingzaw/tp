# User Guide

## Introduction

All-in-oneNUS is a **desktop application for making university life easier in NUS.** 
It has 4 different tools, and is optimized for use via a Command Line Interface (CLI). 
- The TeamPlanner feature allows for quick and easy management of team members and the tasks assigned to each team member. 
- The ModulePlanner feature is a module management tool to allow students gain more insights into the modules that they are interested in. 
- The CapCalculator feature is a calculation tool that has the ability to assign a module to be non-graded during the calculation. 
- The FoodRecommendation feature allows users to review food choices at a single glance and recommends the user a food store accordingly.

* Table of Contents
  * [Quick Start](#Quick-Start)
  * [Features](#Features)
    * [Main Menu](#Main-Menu)
    * [Team Planner](#Team-Planner)
      * [Add team member](#add-team-member-requires-password)
      * [Delete team member](#delete-team-member-requires-password)
      * [Clear team](#clear-team-requires-password)
      * [Show team](#Show-team)
      * [Show commands](#Show-commands)
      * [Quit](#Quit)
    * [Cap Calculator](#Cap-Calculator)
      * [add](#add)
      * [delete](#delete)
      * [list](#list)
      * [edit](#edit)
      * [calculate](#calculate)
    * [Module Planner](#Module-Planner)
      * [module](#module)
      * [student](#student)
      * [list down](#list-down)
      * [recommendation](#recommendation)
    * [Food Recommendation app](#Food-Recommendation-app)
      * [add](#add-food-store)
      * [delete](#delete-food-store)
      * [list](#list-food-stores)
      * [clear](#clear-food-stores)
      * [recommend](#recommend-food-store)
  * [FAQ](#FAQ)
  * [Command Summary](#Command-Summary)
***
## Quick Start

1. Ensure that you have Java 11 or above installed.
2. Download the latest version of `Duke` from [here](https://github.com/AY2021S2-CS2113T-T09-3/tp/releases).
***
## Features

### Main Menu
Accesses the respective tool

Format: `[NUMBER]`

* Entering `1` directs you to the Team Planner
* Entering `2` directs you to the Module Planner
* Entering `3` directs you to the Cap Calculator
* Entering `4` directs you to the Food Recommendation app
***
### Team Planner

When the TeamPlanner feature is selected, the program will prompt and display to the user the following:
- Input the name of the team leader
- Input the size of the team excluding the leader
- Input a password and re-input the password to confirm the password
- Shows the user the list of commands available

The following are the commands that are available in the TeamPlanner feature

#### Add team member (Requires Password)
Adds a team member to the team

Format: `add member [member name]`

#### Delete team member (Requires Password)
Deletes a team member from the team

Format: `delete member [member index]`

#### Clear team (Requires Password)
Clears the members in the team.
This will prompt the user to re-enter all information fields, such as
the team leader, size of the team, team members, as well as the password.

Format: `clear members`

#### Show team
Shows the current members in the team

Format: `show members`

#### Show commands
Lists the commands available

Format: `show commands`

#### Quit
Quits the Team Planner interface
Format: `quit`

***
### Cap Calculator

#### Add
Enter the module code followed by your grade and then the MCs

Format: `[Module Code] [Grade] [MCs]`

#### Delete
Enter delete first. The program will then prompt which module you want to delete. Enter the module

Format: `delete [MODULE CODE]`

#### List
Lists out all modules you have for the semester

Format: `list`

#### Edit
Enter edit then enter the Module which you want the grade to be changed

Format: `edit [Module Code] [new grade]`

#### Calculate
Calculates your CAP for the semester

Format: `calculate`

***

### Module Planner

#### Module
Enter the module code followed by the number of slots available.

Format: `module [module code],[slots]`

<<<<<<< HEAD
#### student
Enter the student information and the rank they want to put for bidding the module. Enter [true]/[false] for [graduation requirement] to indicate whether the module is required for graduation.

Format: `student [name],[year],[graduation requirement],[rank]`

#### list down
Lists down the students and their priority who want to get the module. It is sorted in descending order by their priority score.
=======
#### Student
Enter the student information and the rank they want to put for bidding the module. 

Enter [true]/[false] for [graduation requirement] to indicate whether the module is required for graduation.

Format: `student [name],[year],[graduation requirement],[rank]`

#### List down
Lists down the students and their priority who want to get the module. 

It is sorted in descending order by their priority score.
>>>>>>> 3dc60c54428d4dd712e2c4af2262444c9a8d7ca4

Format: `list`

#### Recommendation
Shows the number of students who have higher priority and predicts the chances of getting that module (High, medium or low)

Format: `recommendation [name]`

***
### Food Recommendation app

#### Add Food Store
Adds a food store with the desired description

Format: `add [Name], [Description]`


#### Delete Food Store
Deletes a food store with the indicated index

Format: `delete [store index]`

#### List Food Stores
Prints the list of food stores that are stored in the app

Format: `list`

#### Clear Food Stores
Clears the entire list of food stores

Format: `clear`

#### Recommend Food Store
Prints a random food store from the list to recommend to the user

Format: `recommend`

***
## FAQ

**Q**: How do I transfer my data to another computer?

**A**: Copy the `.jar` file along with the `team.txt`, `Food Recommendation.txt`, `ModulePlanner.txt` and
`ModuleStorage.txt` to the destination folder.

## Command Summary

{Give a 'cheat sheet' of commands here}
{To be updated}

* Add todo `todo n/TODO_NAME d/DEADLINE`

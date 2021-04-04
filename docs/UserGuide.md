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
      * [Delete](#Delete-student)
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
2. Download the latest version of `All-in-One-NUS` from [here](https://github.com/AY2021S2-CS2113T-T09-3/tp/releases).

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

#### Outline

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

#### Add team member (Requires Password)
Adds a team member to the team

Format: `add member [member name]`

#### Delete team member (Requires Password)
Deletes a team member from the team

Format: `delete member [member index]`

#### Show team
Shows the current members in the team

Format: `show members`

#### Clear team (Requires Password)
Clears the members in the team.
This will prompt the user to re-enter all information fields, such as
the team leader, size of the team, team members, as well as the password.

Format: `clear members`

#### Show commands
Lists the commands available

Format: `help`

#### Add a task to a team member
Adds a task to a team member on the team.

When the command is entered into the CLI, the following prompts will appear:
1. Member to add task to: Key in a team member on the team to assign the task to.
2. Task to be added: Key in the task to assign to the team member.
3. Priority level of the task: Key in the priority level of the task(HIGH/MED/LOW). Take note that the input has to
be capitalised.
   
Format: `add task`

#### Delete a task from a team member
Deletes a task from a team member on the team

When the command is entered into the CLI, the following prompts will appear:
1. Member to delete task from: Key in the member the relevant task has been assigned to.
2. Index of task to be deleted: Key in the index of the task to be deleted. The task index can be retrieved by using 
   the show tasks command.
   
Format: `delete task`

#### Mark task as done
Marks a task assigned to a team member as done

When the command is entered into the CLI, the following prompts will appear:
1. Member the task is assigned to: Key in the member the relevant task has been assigned to.
2. Index of task to be marked as done: Key in the index of the task to be marked as done. 
   The task index can be retrieved by using the show tasks command.

Format: `mark done`

#### Show tasks
Displays the tasks assigned to each team member.

Format: `show tasks`

#### Quit
Quits the Team Planner interface
Format: `quit`

***
### Cap Calculator

#### Add
Adds your module data

Format: `add [Module Code] [Grade] [MCs]`

Example: `add CS1231 A- 4`

#### Delete
Delete specified module data

Format: `delete [Module code]`

Example: `delete CS1010`

#### List
Lists your current semester's module data, CAP for your current semester
and overall CAP for Sem 1 to your current semester

Format: `list`

#### Edit
Make edits to your grades for a module

Format: 
1. `edit [Module code]` 

2. `new grade`

Example: 
1. `edit CS1231`

2. `A-`
#### View
View module and CAP information for Year a Semester b

Format: `view [YaSb]`

Example: `view Y1S1`

#### Show
Show all modules from semester 1 to your current sem
Format: `show`

#### Goal
Simulate the CAP you should get in order to attain your desired overall CAP

IMPORTANT NOTE: Please fill your current semester with modules you are currently taking

This includes arbitrary grades and the number of MCs of the modules

Format: `goal [Desired Overall CAP]`

Example: `goal 4.5`

#### Update
Update your current student status should you commence to the next semester

Format: `update YaSb`

If you are going to be a year 3 sem 1 student, you will have to type:

Example: `update Y3S1`

#### Exit
Exit CAP Calculator

Format: `exit`

#### Help

Lists out all options available

Format: `help`

***

### Module Planner

#### Module
Enter the module code followed by the number of slots available.

Format: `module [module code],[slots]`


#### Student
Enter the student information and the rank they want to put for bidding the module. 

Enter [true]/[false] for [graduation requirement] to indicate whether the module is required for graduation.

Format: `student [name],[year],[graduation requirement],[rank]`

#### List down
Lists down the students and their priority who want to get the module. 

It is sorted in descending order by their priority score.

Format: `list`

#### Recommendation
Shows the number of students who have higher priority and predicts the chances of getting that module (High, medium or low)

Format: `recommendation [name]`

#### Delete student
Removes the student from the list.

Format: `delete [index]`

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

# User Guide

## Introduction

All-in-oneNUS is a **desktop application for making university life easier in NUS.** It has 4 different tools, and is 
optimized for use via a Command Line Interface (CLI).

* Table of Contents
{:toc}

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
2. Download the latest version of `Duke` from [here](https://github.com/AY2021S2-CS2113T-T09-3/tp/releases).

## Features 

### Main Menu
Accesses the respective tool

Format: `[NUMBER]`


* Entering `1` directs you to the Team Planner
* Entering `2` directs you to the Module Planner
* Entering `3` directs you to the Cap Calculator
* Entering `4` directs you to the Food Recommendation app

###Team Planner
#### Set team leader
   Set the team member as the team leader
   Format:

#### Add team member
   Adds a team member to the team
#### Delete team member
   Deletes a team member from the team
#### Clear team
   Clears the members in the team
#### Show team
   Shows the current members in the team
#### Quit
   Quits the Team Planner interface

###Cap Calculator
####add
Enter the module code followed by your grade and then the MCs
Format: [Module Code] [Grade] [MCs]

Expected:

####delete
Enter delete first. The program will then prompt which module you want to delete. Enter the module
Format:
delete
[MODULE CODE]

####list
Lists out all modules you have for the semester
Format:

List

####edit
Enter edit then enter the Module which you want the grade to be changed
Format:
edit
[Module Code]
[new grade]

####calculate



###Module Planner
####module
Enter the module code follow by the number of slots available.
Format: module [module code],[slots]

####student
Enter the student information and the rank they want to put for bidding the module. Enter [true]/[false] for [graduation requirement] to indicate whether the module is required for graduation.
Format: student [name],[year],[graduation requirement],[rank]

####list
Format: list

####recommendation
Format: recommendation [name]


### Food Recommendation app

#### 
Adds a new item to the list of todo items.

Format: `todo n/TODO_NAME d/DEADLINE`

* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.  

Example of usage: 

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`

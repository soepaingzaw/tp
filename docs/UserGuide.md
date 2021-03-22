# User Guide

## Introduction

All-in-oneNUS is a **desktop application for making university life easier in NUS.** It has 4 different tools, and is
optimized for use via a Command Line Interface (CLI).

* Table of Contents
  * [Quick Start](#Quick-Start)
  * [Features](#Features)
  * [Main Menu](#Main-Menu)
  * [Team Planner](#Team-Planner)
  * [Cap Calculator](#Cap-Calculator)
  * [Module Planner](#Module-Planner)
  * [Food Recommendation app](#Food-Recommendation-app)


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

#### Add team member
Adds a team member to the team
Format: Add member [member name]

#### Delete team member
Deletes a team member from the team
Format: delete member [member index]

#### Clear team
Clears the members in the team
Format: clear members

#### Show team
Shows the current members in the team
Format: show members
#### Show commands
Lists the commands available
Format: show commands

#### Quit
Quits the Team Planner interface
Format: Quit


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
Enter the module code followed by the number of slots available.
Format: `module [module code],[slots]`

####student
Enter the student information and the rank they want to put for bidding the module. Enter [true]/[false] for [graduation requirement] to indicate whether the module is required for graduation.
Format: `student [name],[year],[graduation requirement],[rank]`

####list
Lists down the students and their priority who want to get the module. It is sorted in descending order by their priority score.
Format: `list`
####recommendation
Shows the number of students who have higher priority and predicts the chances of getting that module (High, medium or low)
Format: `recommendation [name]`


###Food Recommendation app

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

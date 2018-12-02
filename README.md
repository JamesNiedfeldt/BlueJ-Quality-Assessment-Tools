## BlueJ-Quality-Assessment-Tools
A BlueJ extension that manages multiple quality assessment tools

## Repository URL
> https://github.com/BlueJ-Code-Quality-Extension-Team/BlueJ-Quality-Assessment-Tools

## Project background
BlueJ Code Quality Extension Tools is a BlueJ extension intended to be a parent extension for code quality tools. The current implementation includes a complete checkstyle distribution and a PMD facility that needs to be connected to a distribution of PMD. This extension is intended to be open to the easy addition of further code quality tools.

The parent extension is under the com.bluejmanager package. This package exposes an API to use for adding additional code quality tools. Checkstyle and PMD each have their own packages under com.tools.checkstyle and com.tools.pmd.


## Foundational Work
The checkstyle component included here was taken from the existing *checkstyle4bluej* extension available at
> https://github.com/MetroCS/checkstyle4bluej

## Installation Instructions

Copy the jar file quality-tools-extension-X.Y.Z.jar in the project root directory to the bluej extension directory (../BlueJ/lib/extensions)

#### PMD
For default functionality unzip the desired pmd-bin-\* to the BlueJ lib directory (../BlueJ/lib) into a folder named pmd-bin-\*. The pmd executable files (pmd.bat and run.sh) should be located in the BlueJ folder at ../lib/pmd-bin-\*/bin/ after extraction. At last check, PMD 6.9.0 has this required directory structure. The current distirbution, **pmd-bin-6.9.0.zip**, can be downloaded from

> https://pmd.github.io/

To use an installation other than the default point, open BlueJ's preferences and set Path to PMD to the absolute path of the PMD installation file (pmd.bat or run.sh). 

Checks can also be set or modified. You can set the checks in BlueJ's preferences, either by typing the desired PMD built-in catagory, or entering the absolute path of a single XML file with the desired checks and rules.

## Configuration / System Requirements
- BlueJ 4.1.4 | https://www.bluej.org/

## Development Environment
- java 1.8.0
- javac 1.8.0
- ant 1.10.5

## Team Members
- James Niedfeldt | jniedfe1@msudenver.edu
- Jon Bowen | jbowen10@msudenver.edu
- Sky Liu | tliu1@msudenver.edu
- Travis Rebhan | trebhan@msudenver.edu

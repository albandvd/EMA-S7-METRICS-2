# Metrics Exercice 7

## Command details: 

command: mvn clean
phases: clean 
files modifed: all files in /target are deleted 

command: mvn test
phases: validate / compile / test-compile / test
files modifed: generate classes and unit test

command: mvn package
phases: validate / compile / test-compile / test / package
files modifed/ created: same as mvn test but add artifacs

## Run mvn verify and write down your hypothesis: how is verify different from test and package?

verify is a quality gate: unlike test (code correctness) and package (artifact creation), verify ensures that the packaged application is valid and ready for installation or deployment.
## oa-elevator
An elevator simulator for OA.

It has three elevators to choose from `Simple`, `Time Optimal` and `Willy Wonka`. I hope you enjoy the simulation. 
Instructions for how to build and run the simulations are below.  

*Note*: This code comes with no warranty whatsoever! So, run at your own risk. There is licencing on this you are free 
to use as you see fit. 

## Requirements
Create an elevator simulator and create an executable, or script, that can be run with the following inputs and 
generate the following outputs.
- Inputs: list of floors to visit (e.g elevator start=12 floor=2,9,1,32)
- Outputs: total travel time, floors visited in order (e.g 560 12,2,9,1,32)
- Program Constants: Single floor travel time: 10

## Assumptions
Each specific implementation of the elevator has a description of what it does and any assumptions made. 

## How to Run
How to build in the project directory `oa-elevator` run `mvn clean install`. 
### Using Java 
For the project directory run the following for the simple elevator:
```bash
java -jar ./target/oa-elevator-1.0-SNAPSHOT-jar-with-dependencies.jar startfloor=12 floors=2,9,1,32
```
for the time optimal'ish elevator:
```bash
java -jar ./target/oa-elevator-1.0-SNAPSHOT-jar-with-dependencies.jar o startfloor=12 floors=2,9,1,32
```
for the Willy Wonka elevator:
```bash
java -jar ./target/oa-elevator-1.0-SNAPSHOT-jar-with-dependencies.jar w startfloor=1,2 'floors=(1,2),(3,4),(5,6)'
```
### Using the Script
Move to the `script` folder in project directory and make sure the `oa-elevator.sh` has executable permissions if it 
does not then add it using `chmod +x oa-elevator.sh`. The script assumes that the `oa-elevator.jar` file is located in 
same directory as the script.

Run the following for the simple elevator:
```bash
./oa-elevator startfloor=12 floors=2,9,1,32
```
for the time optimal'ish elevator:
```bash
./oa-elevator  o startfloor=12 floors=2,9,1,32
```
for the Willy Wonka elevator:
```bash
./oa-elevator w startfloor=1,2 'floors=(1,2),(3,4),(5,6)'
```
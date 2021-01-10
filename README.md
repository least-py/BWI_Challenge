![](truck.jpg)

# BWI_Challenge

A program to solve the [BWI Challenge](https://www.get-in-it.de/coding-challenge). The aim is to achieve the highest possible utility value. The details of the goods to be transported (utility value, weight, units) are listed here: [Transport details](https://www.get-in-it.de/imgs/it/codingCompetition/bwi/code_for_bwi.pdf). 
This programme uses a heuristic for the problem that is based on the principle of a greedy algorithm. A Documentation of the classes and their methods can be found inside the doc-folder.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

JavaSE-12 (includes the JDK and JRE)

### Installing
for Windows:

- Download the .zip file and unzip it at your current directoty (Use the path where the unzipped folder was placed. In the following referred as an example: _C:\Users\username\Downloads_)

- Now open cmd:

``` cd C:\Users\username\Downloads\BWI_Challenge-master\BWI_Challenge-master\BWI_Challenge\src\greedy_algorithm ```

``` javac *.java ```

``` cd .. ```

``` java greedy_algorithm.Coordination ```

Now the program should run and produce the following output inside the console.

### Console Output
```
First Truck:
Units: 59	Priority: 0.04184100418410042	Item: Mobiltelefon Buero 	Value: 30 	Weight: 717
Units: 157	Priority: 0.06072874493927125	Item: Mobiltelefon Outdoor 	Value: 60 	Weight: 988
Units: 220	Priority: 0.05327868852459016	Item: Mobiltelefon Heavy Duty 	Value: 65 	Weight: 1220
Units: 283	Priority: 0.03434343434343434	Item: Tablet outdoor groß 	Value: 68 	Weight: 1980
Units: 1	Priority: 0.028469750889679714	Item: Tablet Buero klein 	Value: 40 	Weight: 1405
-----------------------------------------------------------------------------------------------------------------
Second Truck:
Units: 598	Priority: 0.028469750889679714	Item: Tablet Buero klein 	Value: 40 	Weight: 1405
Units: 87	Priority: 0.03434343434343434	Item: Tablet outdoor groß 	Value: 68 	Weight: 1980
Units: 1	Priority: 0.026627218934911243	Item: Tablet outdoor klein 	Value: 45 	Weight: 1690
-----------------------------------------------------------------------------------------------------------------

loaded value in first truck: 44774
loaded value in second truck: 29881

remaining space in the first truck: 36.0
remaining space in the second truck: 160.0
```

Picture from: <a href="https://pixabay.com/de/users/geralt-9301/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=3814429">Gerd Altmann</a> auf <a href="https://pixabay.com/de/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=3814429">Pixabay</a>

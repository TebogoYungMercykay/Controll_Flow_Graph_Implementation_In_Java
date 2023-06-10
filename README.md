# CONTROL FLOW GRAPH.
---
- # `INTRODUCTION`
	- ## `Graphs`.
		- A Graph is a collection of vertices and connections between them.
		- The verticesare nodes and the connections are known as edges.
		- Each edge connects a pairof vertices. If the edges are directional, the graph is known as a directed graph.
		- Each edge can be assigned a number that represents values such as cost, distance,length or weight. Such a graph is then called a weighted directed graph.
	- ## `Control Flow Graphs`.
		- Developed by Frances E. Allen in the 1970s [All70], Control Flow Graphs (CFG)are a static analysis of software code used in software testing.
		- Blocks of code inthe source code represent nodes in the graph. Sequential flows between blocks ofcode represent edges between nodes. CFG have designated entry points and exitpoints.
		- A CFG is known as a Single Entry Single Exit (SESE) graph if it only hasa single entry node and a single exit node. A problem that arose during researchon static analysis is how to deal with loops in the CFG.
		- In an attempt to solvethese issues, Simple and Prime paths were introduced.
	- ## `Simple Paths`
		- From theory, it should be clear that loops are problematic. It is not always possibleto know at compile time or even before then how many times the loop wouldbe executed.
		- This problem is similar to that of the Halting Problem (which isalgorithmically unsolvable) [Bur87].
		- In an attempt to approach this problem, CFGs make use of something called a
		- Simple Path. A Simple Path is a path of any length that satisfies the followingproperties
			- Only the first and last node in the path may be repeated.
			- All edges used in the path needs to exist in the graph.
	- ## `Prime Paths`
		- To reduce the possible paths created by Simple Paths, Prime Paths were intro-duced.
		- A Prime Path is a Simple Path that is not a sub-path of another SimplePath. In other words, a Prime Path is the longest Simple Path that does not formpart of another Simple Path.
---
## REQUIREMENTS BEFORE RUNNING CODES:
- Install an IDE that compiles and runs Java codes. Recommendation `VS Code`
- [link: How to setup `WSL Ubuntu` terminal shell and run it from Visual Studio Code](https://www.youtube.com/watch?v=fp45HpZuhS8&t=112s)
- [link: How to Install Java `JDK 17` on `Windows 11`](https://www.youtube.com/watch?v=ykAhL1IoQUM&t=136s)
- #### Installing Oracle JDK on Windows subsystem for Linux.
	- Run WSL as Administrator
	- set -ex
	- NB: Update links for other JDK Versions
	- export JDK_URL=http://download.oracle.com/otn-pub/java/jdk/8u131-b11/d54c1d3a095b4ff2b6607d096fa80163/jdk-8u131-linux-x64.tar.gz
	- export UNLIMITED_STRENGTH_URL=http://download.oracle.com/otn-pub/java/jce/8/jce_policy-8.zip
	- wget --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" ${JDK_URL}
	- Extract the archive: tar -xzvf jdk-*.tar.gz
	- Clean up the tar: rm -fr jdk-*.tar.gz
	- Make the jvm dir: sudo mkdir -p /usr/lib/jvm
	- Move the server jre: sudo mv jdk1.8* /usr/lib/jvm/oracle_jdk8
	- Install unlimited strength policy: wget --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" ${UNLIMITED_STRENGTH_URL}
	- unzip jce_policy-8.zip
	- mv UnlimitedJCEPolicyJDK8/local_policy.jar /usr/lib/jvm/oracle_jdk8/jre/lib/security/
	- mv UnlimitedJCEPolicyJDK8/US_export_policy.jar /usr/lib/jvm/oracle_jdk8/jre/lib/security/
	- sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/oracle_jdk8/jre/bin/java 2000
	- sudo update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/oracle_jdk8/bin/javac 2000
	- sudo echo "export J2SDKDIR=/usr/lib/jvm/oracle_jdk8 export J2REDIR=/usr/lib/jvm/oracle_jdk8/jre export PATH=$PATH:/usr/lib/jvm/oracle_jdk8/bin:/usr/lib/jvm/oracle_jdk8/db/bin:/usr/lib/jvm/oracle_jdk8/jre/bin export JAVA_HOME=/usr/lib/jvm/oracle_jdk8 export DERBY_HOME=/usr/lib/jvm/oracle_jdk8/db" | sudo tee -a /etc/profile.d/oraclejdk.sh
---

 ## MAKEFILE
 ##### NB: A makefile Is Included to compile and run the codes on the terminal with the following commands:=
- make clean
- make
- make run

```Java
default:
	javac *.java

run:
	java App

clean:
	rm -f *.class
	reset
	clear

tar:
	tar -cvz CFG.java Node.java Edge.java Path.java -f CFG_In_Java.tar.gz

unzip:
	tar -zxvf *.tar
```
---
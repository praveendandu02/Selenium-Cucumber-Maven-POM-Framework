# Selenium-Cucumber-Maven-POM-Framework
Setting up a Cucumber Project in Eclipse using Maven

Maven Cucumber and WebDriver Projects in Eclipse

In our Selenium courses we tend to use Ant for building, executing from command line, and creating reports. However, you may wish to use Maven, which makes projects much easier to manage. So in this blog we show you how to set up your Cucumber project in Eclipse using Maven instead of Ant.

Java JDK Set up

Maven requires the JDK NOT the JRE, so install Java JDK 1.8 if not installed. Create a JAVA_HOME Windows environment variable that points at the JDK folder (used by Maven command line)

In Eclipse, from the menu, go to Windows->Preferences->Java->Installed JREs and click Add, add path to JDK and make default:

JDK path in Eclipse

Cucumber Eclipse Plugin

Install Cucumber plugin from the marketplace if not installed Help->Install New Software

Cucumber Eclipse Plugin

Create a Maven Project

In Eclipse choose New Project->Maven Project-> Create a simple project ticked -> Next

Maven Project in Eclipse

Give group id (company namespace e.g. com.edgewords) and artefact id (this is the project name e.g. cuke_project) you can also supply a name for the project (anything you like) and a version, you can overwrite this with say 1.0 -> Finish

Configure POM.xml

Go to new project folder in Eclipse and open pom.xml (default view will be on overview tab->go to pom.xml tab to view the xml)

Pom.xml

Create dependencies tags before </project> tag in the pom.xml file:



Add dependencies from maven repository:

Cucumber junit
Cucumber java
Junit
Selenium
NOTE: Easy way to do this – put cursor after open dependencies tag-> hit Ctrl-Space -> Scroll down in pop up box to find; insert dependency-> search for each of the dependencies and click ok on each

Or, just open the Maven repository web site https://mvnrepository.com/ and search for the libraries, the Maven web site gives you the POM entries, so you can just copy & paste

Pom should look like this:

Example Pom.xml in Maven

Surefire & Maven Compiler Plugins

Add maven surefire plugin and maven compiler (used to compile and execute Junit tests) below dependencies:

NOTE: Easy way to do this – put cursor after closed dependencies tag-> hit Ctrl-Space -> Scroll down in pop up box to find; insert plugin-> search for surefire and compiler and click ok on each

Maven Surefire plugin

Eclipse Project Structure

Create folder structure (place our tests in src/test/java). A Maven project has a src/main/java which is for the java applications you develop, src/test/java is for your unit tests, which is what we will use as the surefire plugin will set the scope to this classpath by default.

And create feature, code bindings and runners classes, add the word test onto your runner class name (surefire plugin will run the junit tests/runners that have the word “Test” appended to them by default):

 

Maven Cucumber Project Structure

NOTE: Surefire is used for executing Junit tests testing which is why we can’t get it to run feature files directly. They must go through the Junit runner, naming convention is important too (however you can set it up to run specific test classes if you wish but that requires a bit of configuration)

OK, let’s build our Project:

Go to your project, right-click->Maven->Update Project… (this fetches all the dependencies)
Go to your project, right click-> run as -> Maven clean (removes any old output files)
Go to your project, right click-> run as -> Maven test (compile & execute Junit tests)
Errors

If you get an error such as: Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent! Then you need to tell Eclipse the text encoding to use, so in your pom.xml at the top add:

<properties>

<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>

</properties>

 

Command-line Execution

If you want to run from command line, you also need to download Maven (https://maven.apache.org/download.cgi ), and add the path to the Maven install \bin directory to your Windows system path, open cmd and use mvn –version to check installed OK

To run from command line, open a cmd, cd to the project folder (where pom.xml is), then use:

mvn test

 

Executing specific runners

If you want to just execute a specific runner you can do that in your pom.xml, using:

<plugin>

<groupId>org.apache.maven.plugins</groupId>

<artifactId>maven-surefire-plugin</artifactId>

<version>2.21.0</version>

<configuration>

<includes>

<include>MyRunner.java</include>

</includes>

</configuration>

</plugin>

Where MyRunner.java is the JUnit runner I wish to use.

 

Reporting

Surefire Reports

If you wish to create reports, use the surefire report plugin, so add this to the pom.xml:

<reporting>

<plugins>

<plugin>

<groupId>org.apache.maven.plugins</groupId>

<artifactId>maven–surefire-report-plugin</artifactId>

<version>2.21.0</version>

</plugin>

</plugins>

</reporting>

 

To create reports, we navigate to the project folder and now run from the command:

This creates reports from command line & executes tests, use:

mvn site

This creates an extensive report on project & results in target\site\index.html

mvn surefire-report:report

This just creates the brief test run result summary in target\site\surefire-report.html

 

Local Repositories

If you want to use local repository for your dependencies instead of online Maven Repository, you can add this to the top of your pom.xml:

 

<repositories>

<repository>

<id>local-repo</id>

<url>file:///c:/repo</url>

</repository>

</repositories>

 

Where the <url> can be http:// or file:// protocol.

 

POM.xml

Finally, here is a completed pom.xml example:


<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>Selenium-Cucumber-Maven</groupId>
  <artifactId>Selenium-Cucumber-Maven</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  
   <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>

  <dependencies>
     <dependency>
            <groupId>info.cukes</groupId>
            <artifactId>cucumber-testng</artifactId>
            <version>1.2.5</version>
        </dependency>
     <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
	 <dependency>
	    <groupId>junit</groupId>
	    <artifactId>junit</artifactId>
	    <version>4.12</version>
	    <scope>test</scope>
	 </dependency>
     <dependency>
	    <groupId>org.seleniumhq.selenium</groupId>
	    <artifactId>selenium-java</artifactId>
	    <version>3.7.0</version>
	</dependency>
	<dependency>
	    <groupId>info.cukes</groupId>
	    <artifactId>cucumber-java</artifactId>
	    <version>1.2.5</version>
	</dependency>
	<dependency>
	    <groupId>info.cukes</groupId>
	    <artifactId>cucumber-jvm-deps</artifactId>
	    <version>1.0.5</version>
	    <scope>provided</scope>
	</dependency>
	<dependency>
	    <groupId>info.cukes</groupId>
	    <artifactId>cucumber-junit</artifactId>
	    <version>1.2.5</version>
	    <scope>test</scope>
	</dependency>
	<dependency>
	    <groupId>info.cukes</groupId>
	    <artifactId>cucumber-picocontainer</artifactId>
	    <version>1.2.5</version>
	    <scope>test</scope>
	</dependency>
	<dependency>
	    <groupId>com.aventstack</groupId>
	    <artifactId>extentreports</artifactId>
	    <version>3.1.2</version>
	</dependency>
	<dependency>
	    <groupId>com.vimalselvam</groupId>
	    <artifactId>cucumber-extentsreport</artifactId>
	    <version>3.0.2</version>
	</dependency>
  </dependencies>
  
    <build>
	    <plugins>
		  <plugin>
			<groupId>org.apache.maven.plugins</groupId>
			<artifactId>maven-compiler-plugin</artifactId>
			<version>3.7.0</version>
			<configuration>
			  <source>1.8</source>
			  <target>1.8</target>
			   <encoding>UTF-8</encoding>
			</configuration>
		  </plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-plugin</artifactId>
				<version>3.0.0-M3</version>
				<configuration>
				<includes>
                <include>**/*TestRunner.java</include>
				</includes>
                        <!-- <systemPropertyVariables> <xmlFiles>>${xmlFiles}</xmlFiles> <url>${url}</url> 
						<executionBrowser>${browser}</executionBrowser> </systemPropertyVariables> 
						<suiteXmlFiles> <suiteXmlFile>XMLFiles/${xmlFiles}</suiteXmlFile> </suiteXmlFiles> -->

				</configuration>
			</plugin>
      	</plugins>
  	</build>
  
</project>

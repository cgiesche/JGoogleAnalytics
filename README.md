JGoogleAnalytics
================
JGoogleAnalytics is a Java library that allows you to easily collect usage statistics for applications via Google Analytics.

[![Build Status](http://travis-ci.org/cgiesche/JGoogleAnalytics.svg?branch=master)](https://travis-ci.org/cgiesche/JGoogleAnalytics)
[![Coverage Status](http://coveralls.io/repos/cgiesche/JGoogleAnalytics/badge.png)](https://coveralls.io/r/cgiesche/JGoogleAnalytics)

Features
--------
  * Easy to use (zero configuration)
  * Failsafe: Does not break your application in case of an error (eg. no internet connection available)
  * Customizable: Create custom analytics request by using annotations on pojos
  * Full-Featured: Supports all [Google Analytics Hit-Types](https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters):
    * pageview
    * appview
    * event
    * transaction
    * item
    * social
    * exception
    * timing

Installation
------------
As long as this project has not been released (see Milestones), you have to build it by yourself. The only things you need are:

  * a git client (to checkout sources ;)
  * installed JDK >= 1.7
  * a working Apache Maven installation

To build and install the library, simply clone the git repository and run:

    mvn clean install

Example Usage
-------------
JGoogleAnalytics is designed to be full featured but still easy to use. Most settings have useful defaults - the only thing you have to provide is your Google Analytics tracking id.

To track a simple "event", you just need to code the following lines:
```java
final Configuration configuration = new Configuration(TRACKING_ID);
final Collector collector = new Collector(configuration);

collector.collect(new Event("MyEventCategory", "MyEventAction"));
```
Tracking a social network action:
```java
collector.collect(new Social("Facebook", "like", "http://www.github.com"));
```
Of course, you can add a lot of additional data to nearly every kind of HitType:
```java
final Event event = new Event("ApplicationMenu", "MouseClicked").label("times").value(4);
event.with(new AppInfo("MyAppName").version("1.2"));

collector.collect(event);
```

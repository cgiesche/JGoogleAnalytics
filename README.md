JGoogleAnalytics
================
JGoogleAnalytics is a Java library that allows you to easily collect usage statistics for applications via Google Analytics.

Features
--------
  * Easy to use (zero configuration)
  * Failsafe: Does not break your application in case of an error (eg. no internet connection available)
  * Customizable: Create custom analytics request by using annotations on pojos
  * Full-Featured: Supports all Google Analytics Hit-Types:
    * pageview
    * appview
    * event
    * transaction
    * item
    * social
    * exception
    * timing

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
final Event event = new Event("ApplicationMenu", "MouseClicks").label("count").value(4);
event.with(new AppInfo("MyAppName").version("1.2"));

collector.collect(event);
```

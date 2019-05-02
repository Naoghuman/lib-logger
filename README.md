Lib-Logger
===

[![Build Status](https://travis-ci.org/Naoghuman/lib-logger.svg?branch=master)](https://travis-ci.org/Naoghuman/lib-logger)
[![license: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
[![GitHub release](https://img.shields.io/github/release/Naoghuman/lib-logger.svg)](https://GitHub.com/Naoghuman/lib-logger/releases/)



Intention
---

`Lib-Logger` is a library for `easy` logging with the [Apache Log4j 2] in a 
Java(FX) &amp; [Maven] desktop application.

_Image:_ [UML] Lib-Logger  
![UML-diagram_Lib-Logger_v0.6.0_2018-01-14_11-00.png][UML-diagram_Lib-Logger_v0.6.0_2018-01-14_11-00]

> __Hint__  
> The `UML` diagram is created with the `Online Modeling Platform` [GenMyModel].



Content
---

* [Examples](#Examples)
    * [How to configure a project for logging](#HoToCoThFoLo)
    * [How to log a regular message](#HoToLoAReMe)
    * [How to log a starting message](#HoToLoAStMe)
* [JavaDoc](#JavaDoc)
* [Download](#Download)
* [Requirements](#Requirements)
* [Installation](#Installation)
* [Contribution](#Contribution)
* [License](#License)
* [Autor](#Autor)
* [Contact](#Contact)



Examples<a name="Examples" />
---


### How to configure a project for logging<a name="HoToCoThFoLo" />

In this example I want to show you how to configure a [Java] or [JavaFX] project 
for the usage from the library `Lib-Logger`.

* First move the file `log4j2-template.xml` from the GitHub project into the default 
  package `src/main/resources` in your project.
* Then rename the file to 'log4j2.xml'.
* Open the file and tweak it for your necessities. Plz see for more informations:
    * [Log4j XML Configuration Prime]
    * [Log4j – Configuring Log4j 2 - Apache Log4j 2]
    * [Log4j – Frequently Asked Questions - Apache Log4j 2]
* If your project is hosted on GitHub or another development platform then don't 
  forgot to add the folder `/log/` to your `.gitignore` file.


### How to log a regular message<a name="HoToLoAReMe" />

In the first example the developer can see `how to configure a project for logging` 
purpose. With this requirements its now possible to log `normal` messages like:

Example how to log a `debug` message
```java
public static final void loadResourcesInCache() {
    LoggerFacade.getDefault().debug(TemplateLoader.class, "Load resources in cache"); // NOI18N

    ...
}

// which will print in the console and in the configured `xy.log` file:
2017-05-27 08:56:53,757  DEBUG Load resources in cache     [TemplateLoader]
```

Example how to log a `info` message
```java
@Override
public void initialize(URL location, ResourceBundle resources) {
    LoggerFacade.getDefault().info(this.getClass(), "Initialize ApplicationPresenter"); // NOI18N

    ...        
}

// which will print in the console and in the configured `xy.log` file:
2017-05-27 08:56:55,073  INFO  Initialize ApplicationPresenter     [ApplicationPresenter]
```

Example how to log a `error` message
```java
private static String getResource(String name) {
    String loadedResource = null;
    try {
        final URL url = new URL(name);
        loadedResource = getResource(url.openStream());
    } catch(IOException ex){
        LoggerFacade.getDefault().error(ProjectCollector.class, "Error read resources: " + name, ex); // NOI18N
    }
        
    return loadedResource;
}
```


### How to log a starting message<a name="HoToLoAStMe" />

This example will show you how to log a starting message with following statements:

```java
public class StartApplication extends Application implements IApplicationConfiguration {

    @Override
    public void init() throws Exception {
        
        PropertiesFacade.getDefault().register(KEY__APPLICATION__RESOURCE_BUNDLE);
        PropertiesFacade.getDefault().register(ITemplateConfiguration.KEY__TEMPLATE__RESOURCE_BUNDLE);
        
        final char borderSign = this.getProperty(KEY__APPLICATION__BORDER_SIGN).charAt(0);
        final String message = this.getProperty(KEY__APPLICATION__MESSAGE_START);
        final String title = this.getProperty(KEY__APPLICATION__TITLE) + this.getProperty(KEY__APPLICATION__VERSION);
        LoggerFacade.getDefault().message(borderSign, 80, String.format(message, title));
        
        ...
    }
    ...
}

// which will print in the console and in the configured `xy.log` file:
2017-05-27 08:56:53,688  DEBUG Load properties: /com/github/naoghuman/demo/template/application/application.properties     [LibProperties]
2017-05-27 08:56:53,705  DEBUG Load properties: /com/github/naoghuman/demo/template/template.properties     [LibProperties]
2017-05-27 08:56:53,706  INFO  
################################################################################
Start Demo-Template v0.1.0-SNAPSHOT.
################################################################################     [Logger]
```

where the `constants` defined in
```java
public interface IApplicationConfiguration {
    
    public static final String KEY__APPLICATION__BORDER_SIGN     = "application.border.sign"; // NOI18N
    public static final String KEY__APPLICATION__MESSAGE_START   = "application.message.start"; // NOI18N
    public static final String KEY__APPLICATION__RESOURCE_BUNDLE = "/com/github/naoghuman/demo/template/application/application.properties"; // NOI18N
    public static final String KEY__APPLICATION__TITLE           = "application.title"; // NOI18N
    public static final String KEY__APPLICATION__VERSION         = "application.version"; // NOI18N
    
    ...

}
```

and the key-value pairs in `application.properties`:
```java
# Application
application.border.sign=#
application.message.start=Start %s.
application.message.stop=Stop %s.

# This values will be replaced during startup from the application.
# The format from the title in the application will be: ${pom.name} v${pom.version}
# Be aware from the empty sign between the two parameters.
application.build.datetime=${timestamp}
application.title=${pom.name} 
application.version=v${pom.version}
```



JavaDoc<a name="JavaDoc" />
---

The [JavaDoc] from the library `Lib-Logger` can be explored here: [JavaDoc Lib-Logger]

_Image:_ JavaDoc Lib-Logger  
![Lib-Logger_JavaDoc_v0.7.0_2019-05-02_09-22.png][Lib-Logger_JavaDoc_v0.7.0_2019-05-02_09-22]



Download<a name="Download" />
---

Current `version` is `0.7.0`. Main points in this release are:
* Prepare the library for `Java-11`!
* Connect the GitHub project to Travis CI.
* Move the `JavaDoc` to the GitHub folder `docs/apidocs`.

**Maven coordinates**  
In context from a [Maven] project you can use following maven coordinates: 
```xml
<dependencies>
    <dependency>
        <groupId>com.github.naoghuman</groupId>
        <artifactId>lib-logger</artifactId>
        <version>0.7.0</version>
    </dependency>
</dependencies>
```

**Download manuell**
* [Release v0.7.0] (05.02.2019 / MM.dd.yyyy)

**An overview** about all existings releases can be found here:
* [Overview from all releases in Lib-Logger]



Requirements<a name="Requirements" />
---

* On your system you need [JRE 8] or [JDK 8] installed.
* The library [Lib-Logger-0.7.0.jar](#Installation).
    * Included is the [log4j-api-2.11.2.jar].
    * Included is the [log4j-core-2.11.2.jar].



Installation<a name="Installation" />
---

##### Install the project in your preferred IDE

* If not installed download the [JRE 8] or the [JDK 8].
    * Optional: To work better with [FXML] files in a [JavaFX] application download 
      the [JavaFX Scene Builder] under 'Additional Resources'.
* Choose your preferred IDE (e.g. [NetBeans], [Eclipse] or [IntelliJ IDEA]) for 
  development.
* Download or clone the library [Lib-Logger].



Contribution<a name="Contribution" />
---

* If you find a `Bug` I will be glad if you could report an [Issue].
* If you want to contribute to the project plz fork the project and do a [Pull Request].



License<a name="License" />
---

The project `Lib-Logger` is licensed under [General Public License 3.0].



Autor<a name="Autor" />
---

The project `Lib-Logger` is maintained by me, Peter Rogge. See [Contact](#Contact).



Contact<a name="Contact" />
---

You can reach me under <peter.rogge@yahoo.de>.



[//]: # (Images)
[Lib-Logger_JavaDoc_v0.7.0_2019-05-02_09-22]:https://user-images.githubusercontent.com/8161815/57061126-198f8b80-6cbc-11e9-952d-a27115081d4a.png
[UML-diagram_Lib-Logger_v0.6.0_2018-01-14_11-00]:https://user-images.githubusercontent.com/8161815/34914830-f97a93f0-f91a-11e7-82dd-7018bbaddb1c.png



[//]: # (Links)
[Apache Log4j 2]:https://logging.apache.org/log4j/2.0/index.html
[Eclipse]:https://www.eclipse.org/
[Figlet]:http://www.lemoda.net/games/figlet/figlet-instant.html
[FXML]:http://docs.oracle.com/javafx/2/fxml_get_started/jfxpub-fxml_get_started.htm
[General Public License 3.0]:http://www.gnu.org/licenses/gpl-3.0.en.html
[GenMyModel]:https://www.genmymodel.com/
[IntelliJ IDEA]:http://www.jetbrains.com/idea/
[Issue]:https://github.com/Naoghuman/lib-logger/issues
[Java]:http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html
[JavaDoc]:http://www.oracle.com/technetwork/java/javase/documentation/index-jsp-135444.html
[JavaDoc Lib-Logger]:http://naoghuman.github.io/lib-logger/apidocs
[JavaFX]:http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
[JavaFX Scene Builder]:http://gluonhq.com/labs/scene-builder/
[JDK 8]:http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[JRE 8]:http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
[Lib-Logger]:https://github.com/Naoghuman/lib-logger
[Log4j – Configuring Log4j 2 - Apache Log4j 2]:https://logging.apache.org/log4j/2.x/manual/configuration.html
[Log4j – Frequently Asked Questions - Apache Log4j 2]:https://logging.apache.org/log4j/2.0/faq.html
[Log4j XML Configuration Prime]:https://wiki.apache.org/logging-log4j/Log4jXmlFormat
[log4j-api-2.11.2.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[log4j-core-2.11.2.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[Maven]:http://maven.apache.org/
[NetBeans]:https://netbeans.org/
[Overview from all releases in Lib-Logger]:https://github.com/Naoghuman/lib-logger/releases
[Pull Request]:https://help.github.com/articles/using-pull-requests
[Release v0.7.0]:https://github.com/Naoghuman/lib-logger/releases/tag/v0.7.0
[UML]:https://en.wikipedia.org/wiki/Unified_Modeling_Language

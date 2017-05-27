Lib-Logger
===



Intention
---

`Lib-Logger` is a library for `easy` logging with the [Apache Log4j 2] in a 
[JavaFX] &amp; [Maven] desktop application.

_Image:_ [UML] Lib-Logger  
![UML-diagram_Lib-Logger_v0.5.0_2017-05-26_23-37.png][UML-diagram_Lib-Logger_v0.5.0_2017-05-26_23-37]

> __Hint__  
> The `UML` diagram is created with the `Online Modeling Platform` [GenMyModel].

Current `version` is the release `0.5.0` (05.27.2017).



Content
---

* [Examples](#Examples)
    - [Configure a project for logging](#CoThFoLo)
    - [Log a starting message](#LoAStMe)
    - [Log different regular messages](#LoDiReMe)
* [Api](#Api)
    - [com.github.naoghuman.lib.logger.core.LoggerFacade](#LoggerFacade)
    - [com.github.naoghuman.lib.logger.core.Logger](#Logger)
* [Download](#Download)
* [Requirements](#Requirements)
* [Installation](#Installation)
* [Documentation](#Documentation)
* [Contribution](#Contribution)
* [License](#License)
* [Autor](#Autor)
* [Contact](#Contact)



Examples<a name="Examples" />
---



### Configure a project for logging<a name="CoThFoLo" />

In this example I will show how to configure a [Java] project for the usage from the library `Lib-Logger`:
* Move the file `log4j2.xml` to the default package in `src/main/resources` in your new project.
* Open the file and tweak it for your necessities. Plz see for more informations:
    * [Log4j – Configuring Log4j 2 - Apache Log4j 2]
    * [Log4j – Frequently Asked Questions - Apache Log4j 2]
* That was about it :smile:

_Image:_ Move the template file `log4j2.xml`  
![move-log4j2-to-application_v0.5.0_2017-05-27_08-21.png][move-log4j2-to-application_v0.5.0_2017-05-27_08-21]


### Log a starting message<a name="LoAStMe" />

This example shows how to log a starting message with following statement

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
------------------------------------------------------------------------
Building Demo-Template 0.1.0-SNAPSHOT
------------------------------------------------------------------------

--- exec-maven-plugin:1.2.1:exec (default-cli) @ demo-template ---
2017-05-27 08:56:53,688  DEBUG Load properties: /com/github/naoghuman/demo/template/application/application.properties     [LibProperties]
2017-05-27 08:56:53,705  DEBUG Load properties: /com/github/naoghuman/demo/template/template.properties     [LibProperties]
2017-05-27 08:56:53,706  INFO  
################################################################################
Start Demo-Template v0.1.0-SNAPSHOT.
################################################################################     [Logger]
```

where the constants defined in

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


### Log different regular messages<a name="LoDiReMe" />

While the first example shows how to [Configure a project for logging](#CoThFoLo) 
and the second how to [Log a starting message](#LoAStMe) this example shows how 
to log regular messages with the library [Lib-Logger].

```java
public static final void loadResourcesInCache() {
    LoggerFacade.getDefault().debug(TemplateLoader.class, "Load resources in cache"); // NOI18N

    ...
}

// which will print in the console and in the configured `xy.log` file:
2017-05-27 08:56:53,757  DEBUG Load resources in cache     [TemplateLoader]
```

```java
@Override
public void initialize(URL location, ResourceBundle resources) {
    LoggerFacade.getDefault().info(this.getClass(), "Initialize ApplicationPresenter"); // NOI18N

    ...        
}

// which will print in the console and in the configured `xy.log` file:
2017-05-27 08:56:55,073  INFO  Initialize ApplicationPresenter     [ApplicationPresenter]
```

Here an example how to log an `error` if one happen :smile:

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



Api<a name="Api" />
---


### com.github.naoghuman.lib.logger.core.LoggerFacade<a name="LoggerFacade" />

```java
/**
 * The facade {@link com.github.naoghuman.lib.logger.core.LoggerFacade} provides 
 * access to the logging methods during the Interface 
 * {@link com.github.naoghuman.lib.logger.core.Logger}.
 *
 * @author Naoghuman
 * @see com.github.naoghuman.lib.logger.core.Logger
 */
public final class LoggerFacade implements Logger {
```

```java
/**
 * Returns a singleton instance from the class <code>LoggerFacade</code>.
 * 
 * @return a singleton instance from the class <code>LoggerFacade</code>.
 */
public static final LoggerFacade getDefault();
```


### com.github.naoghuman.lib.logger.core.Logger<a name="Logger" />


```java
/**
 * The <code>Interface</code> for the class {@link com.github.naoghuman.lib.logger.internal.DefaultLogger}.<br>
 * Over the facade {@link com.github.naoghuman.lib.logger.core.LoggerFacade} you 
 * can access the methods in this <code>Interface</code>.
 *
 * @author Naoghuman
 * @see com.github.naoghuman.lib.logger.internal.DefaultLogger
 * @see com.github.naoghuman.lib.logger.core.LoggerFacade
 */
public interface Logger {
```


```java
/**
 * Alloweds the developer to decide if the Logger should log or not.<br>
 * Can be usefull during testing purpose.
 * 
 * @param deactivate <code>Boolean</code> which defined if the Logger should
 * log or not. <code>TRUE</code> if no logging desired, otherwise <code>FALSE</code>
 * for logging.
 */
public void deactivate(final Boolean deactivate);
```
 
```java
/**
 * Print a specific message in debug-mode for the given class if (deactive == 
 * false) and (isDebugEnabled() == true).
 * 
 * @param clazz The class for that the message should print.
 * @param msg The message which sould print.
 * @see #deactivate(java.lang.Boolean)
 * @see org.apache.logging.log4j.Logger#isDebugEnabled() 
 */
public void debug(final Class clazz, final String msg);
```
    
```java
/**
 * Print a specific message in debug-mode with a throwable for the given class 
 * if (deactive == false) and (isDebugEnabled() == true).
 * 
 * @param clazz The class for that the message should print.
 * @param msg The message which sould print.
 * @param ta The error which is thrown.
 * @see #deactivate(java.lang.Boolean)
 * @see org.apache.logging.log4j.Logger#isDebugEnabled() 
 */
public void debug(final Class clazz, final String msg, final Throwable ta);
```
    
```java
/**
 * Let the developer define a log {@link org.apache.logging.log4j.Level} 
 * which will be used in the methods {@link #own(Class, String)} and 
 * {@link #own(Class, String, Throwable)}. Default is {@link org.apache.logging.log4j.Level#DEBUG}.
 * <p>
 * All levels are allowed expected {@link org.apache.logging.log4j.Level#ALL} 
 * and {@link org.apache.logging.log4j.Level#OFF}.
 * 
 * @param level The <code>Level</code> which should be used.
 * @see org.apache.logging.log4j.Level
 * @see #own(Class, String)
 * @see #own(Class, String, Throwable)
 */
public void define(final Level level);
```
    
```java
/**
 * Print a specific message in error-mode for the given class if (deactive == 
 * false) and (isErrorEnabled() == true).
 * 
 * @param clazz The class for that the message should print.
 * @param msg The message which sould print.
 * @see #deactivate(java.lang.Boolean) 
 * @see org.apache.logging.log4j.Logger#isErrorEnabled() 
 */
public void error(final Class clazz, final String msg);
```
    
```java
/**
 * Print a specific message in error-mode with a throwable for the given 
 * class if (deactive == false) and (isErrorEnabled() == true).
 * 
 * @param clazz The class for that the message should print.
 * @param msg The message which sould print.
 * @param ta The error which is thrown.
 * @see #deactivate(java.lang.Boolean)
 * @see org.apache.logging.log4j.Logger#isErrorEnabled() 
 */
public void error(final Class clazz, final String msg, final Throwable ta);
```
    
```java
/**
 * Print a specific message in info-mode for the given class if (deactive == 
 * false) and (isInfoEnabled() == true).
 * 
 * @param clazz The class for that the message should print.
 * @param msg The message which sould print.
 * @see #deactivate(java.lang.Boolean)
 * @see org.apache.logging.log4j.Logger#isInfoEnabled() 
 */
public void info(final Class clazz, final String msg);
```
    
```java
/**
 * Print a specific message in info-mode with a throwable for the given 
 * class if (deactive == false) and (isInfoEnabled() == true).
 * 
 * @param clazz The class for that the message should print.
 * @param msg The message which sould print.
 * @param ta The error which is thrown.
 * @see #deactivate(java.lang.Boolean)
 * @see org.apache.logging.log4j.Logger#isInfoEnabled() 
 */
public void info(final Class clazz, final String msg, final Throwable ta);
```
    
```java
/**
 * This will print a <code>Figlet</code> or <code>normal</code> message in 
 * the logfile.<br>
 * For example with <code>LoggerFacade.getDefault().message('#', 70, figlet);</code>
 * following will print to the log:<p>
 * 
 * #####################################################################<br>
 * Here you will see your message.<br>
 * #####################################################################<p>
 * 
 * Have a look at <code>http://www.lemoda.net/games/message/message-instant.html</code> 
 * how to generate a message-message.
 * 
 * @param borderSign The sign which represent an element from the border.
 * @param borderSignCount Define how much elements have the border.
 * @param figlet The figlet (or in normal format) message between the border.
 */
public void message(final char borderSign, final int borderSignCount, final String figlet);
```
    
```java
/**
 * Print a specific message in the defined log {@link org.apache.logging.log4j.Level} 
 * mode when (deactive == false) and (isLogModeEnabled() == true). The 
 * developer can the log level define in the method {@link #define(Level)}. 
 * Default is that {@link org.apache.logging.log4j.Level#DEBUG}.
 * 
 * @param clazz The class for that the message should print.
 * @param msg The message which sould print.
 * @see #define(Level)
 */
public void own(final Class clazz, final String msg);
```
    
```java
/**
 * Print a specific message in the defined log {@link org.apache.logging.log4j.Level} 
 * mode when (deactive == false) and (isLogModeEnabled() == true). The 
 * developer can the log level define in the method {@link #define(Level)}. 
 * Default is that {@link org.apache.logging.log4j.Level#DEBUG}.
 * 
 * @param clazz The class for that the message should print.
 * @param msg The message which sould print.
 * @param ta The error which is thrown.
 * @see #define(Level)
 */
public void own(final Class clazz, final String msg, final Throwable ta);
```
    
```java
/**
 * Print a specific message in warn-mode for the given class if (deactive == 
 * false) and (isTraceEnabled() == true).
 * 
 * @param clazz The class for that the message should print.
 * @param msg The message which sould print.
 * @see #deactivate(java.lang.Boolean)
 * @see org.apache.logging.log4j.Logger#isTraceEnabled() 
 */
public void trace(final Class clazz, final String msg);
```
    
```java
/**
 * Print a specific message in trace-mode with a throwable for the given 
 * class if (deactive == false) and (isTraceEnabled() == true).
 * 
 * @param clazz The class for that the message should print.
 * @param msg The message which sould print.
 * @param ta The error which is thrown.
 * @see #deactivate(java.lang.Boolean)
 * @see org.apache.logging.log4j.Logger#isTraceEnabled() 
 */
public void trace(final Class clazz, final String msg, final Throwable ta);
```
    
```java
/**
 * Print a specific message in trace-mode for the given class if (deactive == 
 * false) and (isWarnEnabled() == true).
 * 
 * @param clazz The class for that the message should print.
 * @param msg The message which sould print.
 * @see #deactivate(java.lang.Boolean)
 * @see org.apache.logging.log4j.Logger#isWarnEnabled() 
 */
public void warn(final Class clazz, final String msg);
```
    
```java
/**
 * Print a specific message in warn-mode with a throwable for the given 
 * class if (deactive == false) and (isWarnEnabled() == true).
 * 
 * @param clazz The class for that the message should print.
 * @param msg The message which sould print.
 * @param ta The error which is thrown.
 * @see #deactivate(java.lang.Boolean)
 * @see org.apache.logging.log4j.Logger#isWarnEnabled() 
 */
public void warn(final Class clazz, final String msg, final Throwable ta);
```



Download<a name="Download" />
---

Current `version` is `0.5.0`. Main points in this release are:
* This is a major update.
* Create new package structure to reflect my new library conventions.
* Deprecated all old classes and interfaces.
* Update the readme to reflect the changes.
* Update the examples in the readme to clearify the usage from the library.

**Maven coordinates**  
In context from a [Maven] project you can use following maven coordinates: 
```xml
<dependencies>
    <dependency>
        <groupId>com.github.naoghuman</groupId>
        <artifactId>lib-logger</artifactId>
        <version>0.5.0</version>
    </dependency>
</dependencies>
```

**Download manuell**
* [Release v0.5.0 (05.27.2017)]

**An overview** about all existings releases can be found here:
* [Overview from all releases in Lib-Logger]



Requirements<a name="Requirements" />
---

* On your system you need [JRE 8] or [JDK 8] installed.
* The library [Lib-Logger-0.5.0.jar](#Installation).
  * Included is the [log4j-api-2.8.2.jar].
  * Included is the [log4j-core-2.8.2.jar].



Installation<a name="Installation" />
---

##### Install the project in your preferred IDE

* If not installed download the [JRE 8] or the [JDK 8].
  * Optional: To work better with [FXML] files in a [JavaFX] application download 
    the [JavaFX Scene Builder] under 'Additional Resources'.
* Choose your preferred IDE (e.g. [NetBeans], [Eclipse] or [IntelliJ IDEA]) for 
  development.
* Download or clone the library [Lib-Logger].



Documentation<a name="Documentation" />
---

* In section [Api](#Api) you can see the main point(s) to access the functionality 
  in this library.
* For additional information you can see the [JavaDoc] in the library itself.



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
[move-log4j2-to-application_v0.5.0_2017-05-27_08-21]:https://cloud.githubusercontent.com/assets/8161815/26518746/e45ae648-42b6-11e7-9c72-43789dc412e2.png
[UML-diagram_Lib-Logger_v0.5.0_2017-05-26_23-37]:https://cloud.githubusercontent.com/assets/8161815/26513576/8b2d8c82-426c-11e7-98d9-fd54a1943b9f.png



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
[JavaFX]:http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
[JavaFX Scene Builder]:http://gluonhq.com/labs/scene-builder/
[JDK 8]:http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[JRE 8]:http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
[Lib-Logger]:https://github.com/Naoghuman/lib-logger
[Log4j – Configuring Log4j 2 - Apache Log4j 2]:https://logging.apache.org/log4j/2.x/manual/configuration.html
[Log4j – Frequently Asked Questions - Apache Log4j 2]:https://logging.apache.org/log4j/2.0/faq.html
[log4j-api-2.8.2.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[log4j-core-2.8.2.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[Maven]:http://maven.apache.org/
[NetBeans]:https://netbeans.org/
[Overview from all releases in Lib-Logger]:https://github.com/Naoghuman/lib-logger/releases
[Pull Request]:https://help.github.com/articles/using-pull-requests
[Release v0.5.0 (05.27.2017)]:https://github.com/Naoghuman/lib-logger/releases/tag/v0.5.0
[UML]:https://en.wikipedia.org/wiki/Unified_Modeling_Language

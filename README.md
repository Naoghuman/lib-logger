Lib-Logger
==============

A library for `easy` logging with the [Apache Log4j 2] in a [JavaFX] &amp; [Maven] application.

Last release `version` is `0.1.1` (07.2015).



Content
-------

* [Examples](#Examples)
* [Requirements](#Requirements)
* [Installation](#Installation)
* [Documentation](#Documentation)
* [Contribution](#Contribution)
* [License](#License)
* [Autor](#Autor)
* [Contact](#Contact)



Examples<a name="Examples" />
--------

```java
/**
 * The facade {@link de.pro.lib.logger.api.LoggerFacade} provides a 
 * singleton instance of the Interface {@link de.pro.lib.logger.api.ILibLogger}.
 *
 * @author PRo
 * @see de.pro.lib.logger.api.ILibLogger
 */
public final class LoggerFacade
```

```java
/**
 * Print a specific message in debug-mode for the given class if
 * (deactive == false) and isDebugEnabled() == true.
 * 
 * @param clazz The class for that the message should print.
 * @param msg The message which sould print.
 * @see #deactivate(java.lang.Boolean)
 * @see org.apache.logging.log4j.Logger#isDebugEnabled() 
 */
public void debug(Class clazz, String msg);
```

```java
/**
 * Print a specific message in debug-mode with a throwable for the given 
 * class if (deactive == false) and isDebugEnabled() == true.
 * 
 * @param clazz The class for that the message should print.
 * @param msg The message which sould print.
 * @param ta The error which is thrown.
 * @see #deactivate(java.lang.Boolean)
 * @see org.apache.logging.log4j.Logger#isDebugEnabled() 
 */
public void debug(Class clazz, String msg, Throwable ta);
```

```java
/**
 * This will print a <code>Figlet</code> or <code>normal</code> message in 
 * the logfile.<br />
 * For example with <code>Loggerfacade.getDefault().message('#', 70, figlet);</code>
 * following will print to the log:<p>
 * 
 * #####################################################################<br />
 * Here you can see your message message.<br />
 * #####################################################################<p>
 * 
 * Have a look at <code>http://www.lemoda.net/games/message/message-instant.html</code> 
 * how to generate a message-message.
 * 
 * @param borderSign The sign which represent an element from the border.
 * @param borderSignCount Define how much elements have the border.
 * @param figlet The figlet (or in normal format) message between the border.
 */
LoggerFacade.getDefault().message(char borderSign, int borderSignCount, String figlet);
```

For example with `Loggerfacade.getDefault().message('#', 62, figlet);` following message will
logged (Have a look in [Figlet] when you are interested how to gernerate such messages):
```
#############################################################
         __        __   _                                   
         \ \      / /__| | ___ ___  _ __ ___   ___          
          \ \ /\ / / _ \ |/ __/ _ \| '_ ` _ \ / _ \         
           \ V  V /  __/ | (_| (_) | | | | | |  __/         
            \_/\_/ \___|_|\___\___/|_| |_| |_|\___|         
#############################################################
```



Requirements<a name="Requirements" />
------------

* On your system you need [JRE 8] or [JDK 8] installed.
* The library [Lib-Logger-0.1.1.jar](#Installation).
  * Included is the [log4j-api-2.3.jar].
  * Included is the [log4j-core-2.3.jar].



Installation<a name="Installation" />
------------

* If not installed download the [JRE 8] or the [JDK 8].
  * Optional: To work better with [FXML] files in a [JavaFX] application download the [JavaFX Scene Builder] under 'Additional Resources'.
* Choose your preferred IDE (e.g. [NetBeans], [Eclipse] or [IntelliJ IDEA]) for development.
* Download or clone [Lib-Logger].
* Open the project in your IDE and run it.



Documentation<a name="Documentation" />
-------------

Momentary only the [JavaDoc] in the library itself is available.



Contribution<a name="Contribution" />
------------

* If you find a `Bug` I will be glad if you could report an [Issue].
* If you want to contribute to the project plz fork the project and do a [Pull Request].



License<a name="License" />
-------

The project `Lib-Logger` is licensed under [General Public License 3.0].



Autor<a name="Autor" />
-----

The project `Lib-Logger` is maintained by me, Peter Rogge. See [Contact](#Contact).



Contact<a name="Contact" />
-------

You can reach me under <peter.rogge@yahoo.de>.



[//]: # (Links)
[Apache Log4j 2]:https://logging.apache.org/log4j/2.0/index.html
[Eclipse]:https://www.eclipse.org/
[Figlet]:http://www.lemoda.net/games/figlet/figlet-instant.html
[FXML]:http://docs.oracle.com/javafx/2/fxml_get_started/jfxpub-fxml_get_started.htm
[General Public License 3.0]:http://www.gnu.org/licenses/gpl-3.0.en.html
[IntelliJ IDEA]:http://www.jetbrains.com/idea/
[Issue]:https://github.com/Naoghuman/lib-logger/issues
[JavaDoc]:http://www.oracle.com/technetwork/java/javase/documentation/index-jsp-135444.html
[JavaFX]:http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
[JavaFX Scene Builder]:http://www.oracle.com/technetwork/java/javase/downloads/index.html
[JDK 8]:http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[JRE 8]:http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
[Lib-Logger]:https://github.com/Naoghuman/lib-logger
[log4j-api-2.3.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[log4j-core-2.3.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[Maven]:http://maven.apache.org/
[NetBeans]:https://netbeans.org/
[Pull Request]:https://help.github.com/articles/using-pull-requests



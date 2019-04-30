/**
 * Copyright (C) 2014 Naoghuman's dream
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.naoghuman.lib.logger.core;

import org.apache.logging.log4j.Level;

/**
 * The {@code Interface} for the {@code Class} 
 * {@link com.github.naoghuman.lib.logger.internal.DefaultLogger}.
 * <p>
 * Over the facade {@link com.github.naoghuman.lib.logger.core.LoggerFacade} the 
 * developer access to the {@code Implementation} from the methods in this 
 * {@code Interface}.
 *
 * @author Naoghuman
 * @see    com.github.naoghuman.lib.logger.internal.DefaultLogger
 * @see    com.github.naoghuman.lib.logger.core.LoggerFacade
 */
public interface Logger {
    
    /**
     * Alloweds the developer to decide if the Logger should log or not.<br>
     * Can be usefull during testing purpose.
     * 
     * @param deactivate {@code Boolean} which defined if the Logger should log 
     *        or not. {@code TRUE} if no logging desired, otherwise {@code FALSE} 
     *        for logging.
     */
    public void deactivate(final Boolean deactivate);
    
    /**
     * Prints a specific message in debug-mode for the given {@code Class} if 
     * {@code (deactive == FALSE)} and {@code (isDebugEnabled() == TRUE)}.
     * 
     * @param clazz The {@code Class} for that the message should be printed.
     * @param msg   The {@code message} which should be printed.
     * @see    #deactivate(java.lang.Boolean)
     * @see    org.apache.logging.log4j.Logger#isDebugEnabled()
     * @throws NullPointerException if {@code clazz == NULL}.
     * @throws NullPointerException if {@code msg   == NULL}.
     */
    public void debug(final Class clazz, final String msg);
    
    /**
     * Prints a specific message in debug-mode with a throwable for the given 
     * {@code Class} if {@code (deactive == FALSE)} and {@code (isDebugEnabled() == TRUE)}.
     * 
     * @param clazz The {@code Class} for that the message should be printed.
     * @param msg   The {@code message} which should be printed.
     * @param ta    The {@code error} which is thrown.
     * @see    #deactivate(java.lang.Boolean)
     * @see    org.apache.logging.log4j.Logger#isDebugEnabled() 
     * @throws NullPointerException if {@code clazz == NULL}.
     * @throws NullPointerException if {@code msg   == NULL}.
     */
    public void debug(final Class clazz, final String msg, final Throwable ta);
    
    /**
     * Lets the developer define a log {@link org.apache.logging.log4j.Level} 
     * which will be used in the methods {@link #own(Class, String)} and 
     * {@link #own(Class, String, Throwable)}. Default is {@link org.apache.logging.log4j.Level#DEBUG}.
     * <p>
     * All levels are allowed expected {@link org.apache.logging.log4j.Level#ALL} 
     * and {@link org.apache.logging.log4j.Level#OFF}.
     * 
     * @param level The {@code Level} which should be used.
     * @see   org.apache.logging.log4j.Level
     * @see   #own(Class, String)
     * @see   #own(Class, String, Throwable)
     */
    public void define(final Level level);
    
    /**
     * Prints a specific message in error-mode for the given class if 
     * {@code (deactive == FALSE)} and {@code (isErrorEnabled() == TRUE)}.
     * 
     * @param clazz The {@code Class} for that the message should be printed.
     * @param msg   The {@code message} which should be printed.
     * @see    #deactivate(java.lang.Boolean) 
     * @see    org.apache.logging.log4j.Logger#isErrorEnabled() 
     * @throws NullPointerException if {@code clazz == NULL}.
     * @throws NullPointerException if {@code msg   == NULL}.
     */
    public void error(final Class clazz, final String msg);
    
    /**
     * Prints a specific message in error-mode with a throwable for the given 
     * {@code Class} if {@code (deactive == FALSE)} and {@code (isErrorEnabled() == TRUE)}.
     * 
     * @param clazz The {@code Class} for that the message should be printed.
     * @param msg   The {@code message} which should be printed.
     * @param ta    The {@code error} which is thrown.
     * @see    #deactivate(java.lang.Boolean)
     * @see    org.apache.logging.log4j.Logger#isErrorEnabled() 
     * @throws NullPointerException if {@code clazz == NULL}.
     * @throws NullPointerException if {@code msg   == NULL}.
     */
    public void error(final Class clazz, final String msg, final Throwable ta);
    
    /**
     * Prints a specific message in info-mode for the given {@code Class} if 
     * {@code (deactive == FALSE)} and {@code (isInfoEnabled() == TRUE)}.
     * 
     * @param clazz The {@code Class} for that the message should be printed.
     * @param msg   The {@code message} which should be printed.
     * @see    #deactivate(java.lang.Boolean)
     * @see    org.apache.logging.log4j.Logger#isInfoEnabled() 
     * @throws NullPointerException if {@code clazz == NULL}.
     * @throws NullPointerException if {@code msg   == NULL}.
     */
    public void info(final Class clazz, final String msg);
    
    /**
     * Prints a specific message in info-mode with a throwable for the given {@code Class} 
     * if {@code (deactive == FALSE)} and {@code (isInfoEnabled() == TRUE)}.
     * 
     * @param clazz The {@code Class} for that the message should be printed.
     * @param msg   The {@code message} which should be printed.
     * @param ta    The {@code error} which is thrown.
     * @see    #deactivate(java.lang.Boolean)
     * @see    org.apache.logging.log4j.Logger#isInfoEnabled()
     * @throws NullPointerException if {@code clazz == NULL}. 
     * @throws NullPointerException if {@code msg   == NULL}.
     */
    public void info(final Class clazz, final String msg, final Throwable ta);
    
    /**
     * This will print a {@code Figlet} or {@code normal} message in the logfile.<br>
     * For example with {@code LoggerFacade.getDefault().message('#', 70, figlet);}
     * following will print to the log-file:
     * <p>
     * #####################################################################<br>
     * Here you will see your message.<br>
     * #####################################################################
     * <p>
     * Have a look at {@code http://www.lemoda.net/games/message/message-instant.html}
     * how to generate a message-message.
     * 
     * @param borderSign      The {@code sign}sign represent an element from the border.
     * @param borderSignCount Define how much {@code elements} have the border.
     * @param figlet          The {@code figlet} (or in normal format) message between the border.
     */
    public void message(final char borderSign, final int borderSignCount, final String figlet);
    
    /**
     * Prints a specific message in the defined log {@link org.apache.logging.log4j.Level} 
     * mode when {@code (deactive == FALSE)} and {@code (isLogModeEnabled() == TRUE)}.
     * The developer can the log level define in the method {@link #define(Level)}. 
     * Default is that {@link org.apache.logging.log4j.Level#DEBUG}.
     * 
     * @param clazz The {@code Class} for that the message should be printed.
     * @param msg   The {@code message} which should be printed.
     * @see    #define(Level)
     * @throws NullPointerException if {@code clazz == NULL}.
     * @throws NullPointerException if {@code msg   == NULL}.
     */
    public void own(final Class clazz, final String msg);
    
    /**
     * Prints a specific message in the defined log {@link org.apache.logging.log4j.Level} 
     * mode when {@code (deactive == FALSE)} and {@code (isLogModeEnabled() == TRUE)}.
     * The developer can the log level define in the method {@link #define(Level)}. 
     * Default is that {@link org.apache.logging.log4j.Level#DEBUG}.
     * 
     * @param clazz The {@code Class} for that the message should be printed.
     * @param msg   The {@code message} which should be printed.
     * @param ta    The {@code error} which is thrown.
     * @see    #define(Level)
     * @throws NullPointerException if {@code clazz == NULL}.
     * @throws NullPointerException if {@code msg   == NULL}.
     */
    public void own(final Class clazz, final String msg, final Throwable ta);
    
    /**
     * Prints a specific message in warn-mode for the given class if 
     * {@code (deactive == FALSE)} and {@code (isTraceEnabled() == TRUE)}.
     * 
     * @param clazz The {@code Class} for that the message should be printed.
     * @param msg   The {@code message} which should be printed.
     * @see    #deactivate(java.lang.Boolean)
     * @see    org.apache.logging.log4j.Logger#isTraceEnabled() 
     * @throws NullPointerException if {@code clazz == NULL}.
     * @throws NullPointerException if {@code msg   == NULL}.
     */
    public void trace(final Class clazz, final String msg);
    
    /**
     * Prints a specific message in trace-mode with a throwable for the given {@code Class} 
     * if {@code (deactive == FALSE)} and {@code (isTraceEnabled() == TRUE)}.
     * 
     * @param clazz The {@code Class} for that the message should be printed.
     * @param msg   The {@code message} which should be printed.
     * @param ta    The {@code error} which is thrown.
     * @see    #deactivate(java.lang.Boolean)
     * @see    org.apache.logging.log4j.Logger#isTraceEnabled() 
     * @throws NullPointerException if {@code clazz == NULL}.
     * @throws NullPointerException if {@code msg   == NULL}.
     */
    public void trace(final Class clazz, final String msg, final Throwable ta);
    
    /**
     * Prints a specific message in trace-mode for the given {@code Class} if 
     * {@code (deactive == FALSE)} and {@code (isWarnEnabled() == TRUE)}.
     * 
     * @param clazz The {@code Class} for that the message should be printed.
     * @param msg   The {@code message} which should be printed.
     * @see    #deactivate(java.lang.Boolean)
     * @see    org.apache.logging.log4j.Logger#isWarnEnabled() 
     * @throws NullPointerException if {@code clazz == NULL}.
     * @throws NullPointerException if {@code msg   == NULL}.
     */
    public void warn(final Class clazz, final String msg);
    
    /**
     * Prints a specific message in warn-mode with a throwable for the given {@code Class}
     * {@code (deactive == FALSE)} and {@code (isWarnEnabled() == TRUE)}.
     * 
     * @param clazz The class for that the message should be printed.
     * @param msg   The {@code message} which should be printed.
     * @param ta    The {@code error} which is thrown.
     * @see    #deactivate(java.lang.Boolean)
     * @see    org.apache.logging.log4j.Logger#isWarnEnabled()
     * @throws NullPointerException if {@code clazz == NULL}.
     * @throws NullPointerException if {@code msg   == NULL}.
     */
    public void warn(final Class clazz, final String msg, final Throwable ta);
    
}

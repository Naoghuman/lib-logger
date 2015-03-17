/*
 * Copyright (C) 2014 PRo
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
package de.pro.lib.logger.api;

/**
 * The <code>Interface</code> for the class {@link de.pro.lib.logger.PRoLogger}.<br />
 * Over the facade {@link de.pro.lib.logger.api.LoggerFacade} you can access
 * the methods in this <code>Interface</code>.
 *
 * @author PRo
 * @see de.pro.lib.logger.PRoLogger
 * @see de.pro.lib.logger.api.LoggerFacade
 */
public interface ILogger {
    
    /**
     * Alloweds the developer to decide if the Logger should log or not.<br />
     * Can be usefull during testing purpose.
     * 
     * @param deactivate <code>Boolean</code> which defined if the Logger should
     * log or not. <code>TRUE</code> if no logging desired, otherwise <code>FALSE</code>
     * for logging.
     */
    public void deactivate(Boolean deactivate);
    
    /**
     * Print a specific message im debug-mode for the given class if
     * (deactive == false) and isDebugEnabled() == true.
     * 
     * @param clazz The class for that the message should print.
     * @param msg The message which sould print.
     * @see #deactivate(java.lang.Boolean)
     * @see org.apache.logging.log4j.Logger#isDebugEnabled() 
     */
    public void debug(Class clazz, String msg);
    
    /**
     * Print a specific message im debug-mode with a throwable for the given 
     * class if (deactive == false) and isDebugEnabled() == true.
     * 
     * @param clazz The class for that the message should print.
     * @param msg The message which sould print.
     * @param ta The error which is thrown.
     * @see #deactivate(java.lang.Boolean)
     * @see org.apache.logging.log4j.Logger#isDebugEnabled() 
     */
    public void debug(Class clazz, String msg, Throwable ta);
    
    /**
     * Print a specific message im error-mode for the given class if
     * (deactive == false) and isErrorEnabled() == true.
     * 
     * @param clazz The class for that the message should print.
     * @param msg The message which sould print.
     * @see #deactivate(java.lang.Boolean) 
     * @see org.apache.logging.log4j.Logger#isErrorEnabled() 
     */
    public void error(Class clazz, String msg);
    
    /**
     * Print a specific message im error-mode with a throwable for the given 
     * class if (deactive == false) and isErrorEnabled() == true.
     * 
     * @param clazz The class for that the message should print.
     * @param msg The message which sould print.
     * @param ta The error which is thrown.
     * @see #deactivate(java.lang.Boolean)
     * @see org.apache.logging.log4j.Logger#isErrorEnabled() 
     */
    public void error(Class clazz, String msg, Throwable ta);
    
    /**
     * Print a specific message im info-mode for the given class if
     * (deactive == false) and isInfoEnabled() == true.
     * 
     * @param clazz The class for that the message should print.
     * @param msg The message which sould print.
     * @see #deactivate(java.lang.Boolean)
     * @see org.apache.logging.log4j.Logger#isInfoEnabled() 
     */
    public void info(Class clazz, String msg);
    
    /**
     * Print a specific message im info-mode with a throwable for the given 
     * class if (deactive == false) and isInfoEnabled() == true.
     * 
     * @param clazz The class for that the message should print.
     * @param msg The message which sould print.
     * @param ta The error which is thrown.
     * @see #deactivate(java.lang.Boolean)
     * @see org.apache.logging.log4j.Logger#isInfoEnabled() 
     */
    public void info(Class clazz, String msg, Throwable ta);
    
    /**
     * Print a specific message im warn-mode for the given class if
     * (deactive == false) and isTraceEnabled() == true.
     * 
     * @param clazz The class for that the message should print.
     * @param msg The message which sould print.
     * @see #deactivate(java.lang.Boolean)
     * @see org.apache.logging.log4j.Logger#isTraceEnabled() 
     */
    public void trace(Class clazz, String msg);
    
    /**
     * Print a specific message im trace-mode with a throwable for the given 
     * class if (deactive == false) and isTraceEnabled() == true.
     * 
     * @param clazz The class for that the message should print.
     * @param msg The message which sould print.
     * @param ta The error which is thrown.
     * @see #deactivate(java.lang.Boolean)
     * @see org.apache.logging.log4j.Logger#isTraceEnabled() 
     */
    public void trace(Class clazz, String msg, Throwable ta);
    
    /**
     * Print a specific message im trace-mode for the given class if
     * (deactive == false) and isWarnEnabled() == true.
     * 
     * @param clazz The class for that the message should print.
     * @param msg The message which sould print.
     * @see #deactivate(java.lang.Boolean)
     * @see org.apache.logging.log4j.Logger#isWarnEnabled() 
     */
    public void warn(Class clazz, String msg);
    
    /**
     * Print a specific message im warn-mode with a throwable for the given 
     * class if (deactive == false) and isWarnEnabled() == true.
     * 
     * @param clazz The class for that the message should print.
     * @param msg The message which sould print.
     * @param ta The error which is thrown.
     * @see #deactivate(java.lang.Boolean)
     * @see org.apache.logging.log4j.Logger#isWarnEnabled() 
     */
    public void warn(Class clazz, String msg, Throwable ta);
    
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
    public void message(char borderSign, int borderSignCount, String figlet);
    
}

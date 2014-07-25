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
 * The <code>Interface</code> for the class <code>de.pro.lib.logger.PRoLogger</code>.
 * Over the factory <code>de.pro.lib.logger.api.LoggerFactory</code> you can 
 * access the methods in this <code>Interface</code>.
 *
 * @author PRo
 * @see de.pro.lib.logger.PRoLogger
 * @see de.pro.lib.logger.api.LoggerFactory
 */
public interface ILogger {
    /**
     * Print a specific message im debug-mode for the given class.
     * 
     * @param clazz The class for that the message should print.
     * @param msg The message which sould print.
     */
    public void debug(Class clazz, String msg);
    
    /**
     * Print a specific message im debug-mode with a throwable for the given class.
     * 
     * @param clazz The class for that the message should print.
     * @param msg The message which sould print.
     * @param ta The error which is thrown.
     */
    public void debug(Class clazz, String msg, Throwable ta);
    
    /**
     * Print a specific message im error-mode for the given class.
     * 
     * @param clazz The class for that the message should print.
     * @param msg The message which sould print.
     */
    public void error(Class clazz, String msg);
    
    /**
     * Print a specific message im error-mode with a throwable for the given class.
     * 
     * @param clazz The class for that the message should print.
     * @param msg The message which sould print.
     * @param ta The error which is thrown.
     */
    public void error(Class clazz, String msg, Throwable ta);
    
    /**
     * Print a specific message im info-mode for the given class.
     * 
     * @param clazz The class for that the message should print.
     * @param msg The message which sould print.
     */
    public void info(Class clazz, String msg);
    
    /**
     * Print a specific message im info-mode with a throwable for the given class.
     * 
     * @param clazz The class for that the message should print.
     * @param msg The message which sould print.
     * @param ta The error which is thrown.
     */
    public void info(Class clazz, String msg, Throwable ta);
    
    /**
     * Print a specific message im warn-mode for the given class.
     * 
     * @param clazz The class for that the message should print.
     * @param msg The message which sould print.
     */
    public void warn(Class clazz, String msg);
    
    /**
     * Print a specific message im warn-mode with a throwable for the given class.
     * 
     * @param clazz The class for that the message should print.
     * @param msg The message which sould print.
     * @param ta The error which is thrown.
     */
    public void warn(Class clazz, String msg, Throwable ta);
    
    /**
     * This method print a <code>Welcome</code> message at start in the logfile. 
     * The length from the <code>param welcomeMessage</code> shouldn't above 65 
     * characters.<br />
     * The <code>Welcome</code> message will print in the format:<br /><br />
     * 
     * #####################################################################<br />
     * # Here you can read your welcome message&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;#<br />
     * #####################################################################<br /><br />
     * 
     * If your <code>Welcome</code> message is longer then 65 characters then you 
     * you will see:<br /><br />
     * 
     * #####################################################################<br />
     * # Here you can read your to long ..................... welcome message #<br />
     * #####################################################################
     * 
     * @param welcomeMessage the welcome message
     */
    public void sayWelcome(String welcomeMessage);
    
    /**
     * This method print a <code>Goodbye</code> message at start in the logfile. 
     * The length from the <code>param goodbyeMessage</code> shouldn't above 65 
     * characters.<br />
     * The <code>Goodbye</code> message will print in the format:<br /><br />
     * 
     * #####################################################################<br />
     * # Here you can read your goodbye message&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;#<br />
     * #####################################################################<br /><br />
     * 
     * If your <code>Goodbye</code> message is longer then 65 characters then you 
     * you will see:<br /><br />
     * 
     * #####################################################################<br />
     * # Here you can read your to long ..................... goodbye message #<br />
     * #####################################################################
     * 
     * @param goodbyeMessage the goodbye message
     */
    public void sayGoodbye(String goodbyeMessage);
}

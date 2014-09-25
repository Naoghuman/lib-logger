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
     * This will print a <code>Welcome</code> message at start in the logfile
     * between two lines of '#'s with a length from 65 characters.<br />
     * The <code>Welcome</code> message will print in the format:<p>
     * 
     * #####################################################################<br />
     * # &nbsp;&nbsp;Here you can read your welcome message. (fill ' ' to the end of #)<br />
     * #####################################################################
     * 
     * @param welcomeMessage the welcome message
     */
    public void sayWelcome(String welcomeMessage);
    
    /**
     * This will print a <code>Goodbye</code> message at the end in the logfile
     * between two lines of '#'s with a length from 65 characters.<br />
     * The <code>Goodbye</code> message will print in the format:<p>
     * 
     * #####################################################################<br />
     * # &nbsp;&nbsp;Here you can read your goodbye message. (fill ' ' to the end of #)<br />
     * #####################################################################
     * 
     * @param goodbyeMessage the goodbye message
     */
    public void sayGoodbye(String goodbyeMessage);
}

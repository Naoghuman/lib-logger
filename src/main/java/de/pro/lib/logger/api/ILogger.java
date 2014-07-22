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
 *
 * @author PRo
 */
public interface ILogger {
    public void debug(Class clazz, String msg);
    public void debug(Class clazz, String msg, Throwable ta);
    public void error(Class clazz, String msg);
    public void error(Class clazz, String msg, Throwable ta);
    public void info(Class clazz, String msg);
    public void info(Class clazz, String msg, Throwable ta);
    public void warn(Class clazz, String msg);
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

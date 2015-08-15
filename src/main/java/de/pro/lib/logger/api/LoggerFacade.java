/*
 * Copyright (C) 2015 PRo
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

import de.pro.lib.logger.LibLogger;
import org.apache.logging.log4j.Level;

/**
 * The facade {@link de.pro.lib.logger.api.LoggerFacade} provides access to
 * the logging methods during the Interface {@link de.pro.lib.logger.api.ILibLogger}.
 *
 * @author PRo
 * @see de.pro.lib.logger.api.ILibLogger
 */
public enum LoggerFacade implements ILibLogger {
    
    /**
     * Over the value <code>INSTANCE</code> the developer have access to the
     * singleton instance from the <code>LoggerFacade</code>.
     */
    INSTANCE;
    
    private ILibLogger logger = null;
    
    private LoggerFacade() {
        this.initialize();
    }
    
    private void initialize() {
        logger = new LibLogger();
    }

    @Override
    public void deactivate(Boolean deactivate) {
        logger.deactivate(deactivate);
    }

    @Override
    public void debug(Class clazz, String msg) {
        logger.debug(clazz, msg);
    }

    @Override
    public void debug(Class clazz, String msg, Throwable ta) {
        logger.debug(clazz, msg, ta);
    }

    @Override
    public void define(Level level) {
        logger.define(level);
    }

    @Override
    public void error(Class clazz, String msg) {
        logger.error(clazz, msg);
    }

    @Override
    public void error(Class clazz, String msg, Throwable ta) {
        logger.error(clazz, msg, ta);
    }

    @Override
    public void info(Class clazz, String msg) {
        logger.info(clazz, msg);
    }

    @Override
    public void info(Class clazz, String msg, Throwable ta) {
        logger.info(clazz, msg, ta);
    }

    @Override
    public void message(char borderSign, int borderSignCount, String figlet) {
        logger.message(borderSign, borderSignCount, figlet);
    }

    @Override
    public void own(Class clazz, String msg) {
        logger.own(clazz, msg);
    }

    @Override
    public void own(Class clazz, String msg, Throwable ta) {
        logger.own(clazz, msg, ta);
    }

    @Override
    public void trace(Class clazz, String msg) {
        logger.trace(clazz, msg);
    }

    @Override
    public void trace(Class clazz, String msg, Throwable ta) {
        logger.trace(clazz, msg, ta);
    }

    @Override
    public void warn(Class clazz, String msg) {
        logger.warn(clazz, msg);
    }

    @Override
    public void warn(Class clazz, String msg, Throwable ta) {
        logger.warn(clazz, msg, ta);
    }
    
}

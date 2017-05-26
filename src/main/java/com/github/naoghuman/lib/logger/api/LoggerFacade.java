/*
 * Copyright (C) 2015 Naoghuman
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
package com.github.naoghuman.lib.logger.api;

import com.github.naoghuman.lib.logger.LibLogger;
import java.util.Optional;
import org.apache.logging.log4j.Level;

/**
 * The facade {@link com.github.naoghuman.lib.logger.api.LoggerFacade} provides 
 * access to the logging methods during the Interface 
 * {@link com.github.naoghuman.lib.logger.api.ILibLogger}.
 *
 * @author Naoghuman
 * @see com.github.naoghuman.lib.logger.api.ILibLogger
 * @deprecated will be replaced with {@link com.github.naoghuman.lib.logger.core.LoggerFacade}
 */
@Deprecated
public final class LoggerFacade implements ILibLogger {
    
    private static final Optional<LoggerFacade> instance = Optional.of(new LoggerFacade());

    /**
     * Returns a singleton instance from the class <code>LoggerFacade</code>.
     * 
     * @return a singleton instance from the class <code>LoggerFacade</code>.
     */
    @Deprecated
    public static final LoggerFacade getDefault() {
        return instance.get();
    }
    
    private ILibLogger logger = null;
    
    private LoggerFacade() {
        this.initialize();
    }
    
    private void initialize() {
        logger = new LibLogger();
    }

    @Deprecated
    @Override
    public void deactivate(Boolean deactivate) {
        logger.deactivate(deactivate);
    }

    @Deprecated
    @Override
    public void debug(Class clazz, String msg) {
        logger.debug(clazz, msg);
    }

    @Deprecated
    @Override
    public void debug(Class clazz, String msg, Throwable ta) {
        logger.debug(clazz, msg, ta);
    }

    @Deprecated
    @Override
    public void define(Level level) {
        logger.define(level);
    }

    @Deprecated
    @Override
    public void error(Class clazz, String msg) {
        logger.error(clazz, msg);
    }

    @Deprecated
    @Override
    public void error(Class clazz, String msg, Throwable ta) {
        logger.error(clazz, msg, ta);
    }

    @Deprecated
    @Override
    public void info(Class clazz, String msg) {
        logger.info(clazz, msg);
    }

    @Deprecated
    @Override
    public void info(Class clazz, String msg, Throwable ta) {
        logger.info(clazz, msg, ta);
    }

    @Deprecated
    @Override
    public void message(char borderSign, int borderSignCount, String figlet) {
        logger.message(borderSign, borderSignCount, figlet);
    }

    @Deprecated
    @Override
    public void own(Class clazz, String msg) {
        logger.own(clazz, msg);
    }

    @Deprecated
    @Override
    public void own(Class clazz, String msg, Throwable ta) {
        logger.own(clazz, msg, ta);
    }

    @Deprecated
    @Override
    public void trace(Class clazz, String msg) {
        logger.trace(clazz, msg);
    }

    @Deprecated
    @Override
    public void trace(Class clazz, String msg, Throwable ta) {
        logger.trace(clazz, msg, ta);
    }

    @Deprecated
    @Override
    public void warn(Class clazz, String msg) {
        logger.warn(clazz, msg);
    }

    @Deprecated
    @Override
    public void warn(Class clazz, String msg, Throwable ta) {
        logger.warn(clazz, msg, ta);
    }
    
}

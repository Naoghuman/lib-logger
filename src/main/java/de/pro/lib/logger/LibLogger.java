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
package de.pro.lib.logger;

import de.pro.lib.logger.api.ILibLogger;
import java.util.HashMap;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The implementation from the Interface {@link de.pro.lib.logger.api.ILibLogger}.<br />
 * Access to this class is over the facade {@link de.pro.lib.logger.api.LoggerFacade}.
 * 
 * @author PRo
 * @see de.pro.lib.logger.api.ILibLogger
 * @see de.pro.lib.logger.api.LoggerFacade
 */
public final class LibLogger implements ILibLogger {
    
    private final HashMap<Class, Logger> loggers = new HashMap<>();
    
    private Boolean deactivate = Boolean.FALSE;
    private Level level = Level.DEBUG;
    
    /**
     * Default contructor.
     */
    public LibLogger() { }
    
    private Logger getLogger(Class clazz) {
        // Look if the class have a logger
        if (loggers.containsKey(clazz)) {
            return loggers.get(clazz);
        }
        
        // Create new logger
        final Logger logger = LogManager.getLogger(clazz);
        loggers.put(clazz, logger);
        
        return logger;
    }

    @Override
    public void deactivate(Boolean deactivate) {
        this.deactivate = deactivate;
    }

    @Override
    public void debug(Class clazz, String msg) {
        this.debug(clazz, msg, null);
    }

    @Override
    public void debug(Class clazz, String msg, Throwable ta) {
        if (!deactivate && this.getLogger(clazz).isDebugEnabled()) {
            this.getLogger(clazz).debug(msg, ta);
        }
    }

    @Override
    public void define(Level level) {
        if (
                level.equals(Level.ALL)
                || level.equals(Level.OFF)
        ) {
            final String msg = "All level expected Level.ALL and Level.OFF are allowed"; // NOI18N
            throw new IllegalArgumentException(msg);
        }
        
        this.level = level;
    }

    @Override
    public void error(Class clazz, String msg) {
        this.error(clazz, msg, null);
    }

    @Override
    public void error(Class clazz, String msg, Throwable ta) {
        if (!deactivate && this.getLogger(clazz).isErrorEnabled()) {
            this.getLogger(clazz).error(msg, ta);
        }
    }

    @Override
    public void info(Class clazz, String msg) {
        this.info(clazz, msg, null);
    }

    @Override
    public void info(Class clazz, String msg, Throwable ta) {
        if (!deactivate && this.getLogger(clazz).isInfoEnabled()) {
            this.getLogger(clazz).info(msg, ta);
        }
    }

    @Override
    public void message(char borderSign, int borderSignCount, String message) {
        final StringBuilder msg = new StringBuilder();
        msg.append("\n"); // NOI18N
        
        final StringBuilder border = new StringBuilder();
        
        for (int i = 0; i < borderSignCount; i++) {
            border.append(String.valueOf(borderSign));
        }
        msg.append(border.toString()).append("\n"); // NOI18N
        msg.append(message).append("\n"); // NOI18N
        msg.append(border.toString());
        
        this.getLogger(LibLogger.class).info(msg.toString());
    }

    @Override
    public void own(Class clazz, String msg) {
        this.own(clazz, msg, null);
    }

    @Override
    public void own(Class clazz, String msg, Throwable ta) {
        if (deactivate) {
            return;
        }
        
        if (level.equals(Level.DEBUG) && this.getLogger(clazz).isDebugEnabled()) {
            this.getLogger(clazz).debug(msg, ta);
        }
        
        if (level.equals(Level.ERROR) && this.getLogger(clazz).isErrorEnabled()) {
            this.getLogger(clazz).error(msg, ta);
        }
        
        if (level.equals(Level.INFO) && this.getLogger(clazz).isInfoEnabled()) {
            this.getLogger(clazz).info(msg, ta);
        }
        
        if (level.equals(Level.TRACE) && this.getLogger(clazz).isTraceEnabled()) {
            this.getLogger(clazz).trace(msg, ta);
        }
        
        if (level.equals(Level.WARN) && this.getLogger(clazz).isWarnEnabled()) {
            this.getLogger(clazz).warn(msg, ta);
        }
    }

    @Override
    public void trace(Class clazz, String msg) {
        this.trace(clazz, msg, null);
    }

    @Override
    public void trace(Class clazz, String msg, Throwable ta) {
        if (!deactivate && this.getLogger(clazz).isTraceEnabled()) {
            this.getLogger(clazz).trace(msg, ta);
        }
    }

    @Override
    public void warn(Class clazz, String msg) {
        this.warn(clazz, msg, null);
    }

    @Override
    public void warn(Class clazz, String msg, Throwable ta) {
        if (!deactivate && this.getLogger(clazz).isWarnEnabled()) {
            this.getLogger(clazz).warn(msg, ta);
        }
    }
    
}

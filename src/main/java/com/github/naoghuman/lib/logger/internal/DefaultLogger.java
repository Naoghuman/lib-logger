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
package com.github.naoghuman.lib.logger.internal;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

/**
 * The default {@code Implementation} from the {@code Interface} 
 * {@link com.github.naoghuman.lib.logger.core.Logger}.
 * <p>
 * Access to this {@code Class} is over the facade {@link com.github.naoghuman.lib.logger.core.LoggerFacade}.
 * 
 * @author Naoghuman
 * @see    com.github.naoghuman.lib.logger.core.Logger
 * @see    com.github.naoghuman.lib.logger.core.LoggerFacade
 */
public final class DefaultLogger implements com.github.naoghuman.lib.logger.core.Logger {
    
    private final HashMap<Class, org.apache.logging.log4j.Logger> loggers = new HashMap<>();
    
    private Boolean deactivate = Boolean.FALSE;
    private Level level = Level.DEBUG;
    
    /**
     * Default contructor.
     */
    public DefaultLogger() { }
    
    private org.apache.logging.log4j.Logger getLogger(final Class clazz) {
        // Look if the class have a logger
        if (loggers.containsKey(clazz)) {
            return loggers.get(clazz);
        }
        
        // Create new logger
        final org.apache.logging.log4j.Logger logger = LogManager.getLogger(clazz);
        loggers.put(clazz, logger);
        
        return logger;
    }

    @Override
    public final void deactivate(final Boolean deactivate) {
        this.deactivate = deactivate;
    }

    @Override
    public final void debug(final Class clazz, final String msg) {
        this.debug(clazz, msg, null);
    }

    @Override
    public final void debug(final Class clazz, final String msg, final Throwable ta) {
        DefaultLoggerValidator.requireNonNull(clazz);
        DefaultLoggerValidator.requireNonNull(msg);
        
        final org.apache.logging.log4j.Logger logger = this.getLogger(clazz);
        if (!deactivate && logger.isDebugEnabled()) {
            logger.debug(msg, ta);
        }
    }

    @Override
    public final void define(final Level level) {
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
    public final void error(final Class clazz, final String msg) {
        this.error(clazz, msg, null);
    }

    @Override
    public final void error(final Class clazz, final String msg, final Throwable ta) {
        DefaultLoggerValidator.requireNonNull(clazz);
        DefaultLoggerValidator.requireNonNull(msg);
        
        final org.apache.logging.log4j.Logger logger = this.getLogger(clazz);
        if (!deactivate && logger.isErrorEnabled()) {
            logger.error(msg, ta);
        }
    }

    @Override
    public final void info(final Class clazz, final String msg) {
        this.info(clazz, msg, null);
    }

    @Override
    public final void info(final Class clazz, final String msg, final Throwable ta) {
        DefaultLoggerValidator.requireNonNull(clazz);
        DefaultLoggerValidator.requireNonNull(msg);
        
        final org.apache.logging.log4j.Logger logger = this.getLogger(clazz);
        if (!deactivate && logger.isInfoEnabled()) {
            logger.info(msg, ta);
        }
    }

    @Override
    public final void message(final char borderSign, final int borderSignCount, final String message) {
        final StringBuilder msg = new StringBuilder();
        msg.append("\n"); // NOI18N
        
        final StringBuilder border = new StringBuilder();
        for (int i = 0; i < borderSignCount; i++) {
            border.append(String.valueOf(borderSign));
        }
        msg.append(border.toString()).append("\n"); // NOI18N
        msg.append(message).append("\n"); // NOI18N
        msg.append(border.toString());
        
        final org.apache.logging.log4j.Logger logger = this.getLogger(com.github.naoghuman.lib.logger.core.Logger.class);
        logger.info(msg.toString());
    }

    @Override
    public final void own(final Class clazz, final String msg) {
        this.own(clazz, msg, null);
    }

    @Override
    public final void own(final Class clazz, final String msg, final Throwable ta) {
        DefaultLoggerValidator.requireNonNull(clazz);
        DefaultLoggerValidator.requireNonNull(msg);
        
        if (deactivate) {
            return;
        }
        
        final org.apache.logging.log4j.Logger logger = this.getLogger(clazz);
        if (level.equals(Level.DEBUG) && logger.isDebugEnabled()) {
            logger.debug(msg, ta);
        }
        
        if (level.equals(Level.ERROR) && logger.isErrorEnabled()) {
            logger.error(msg, ta);
        }
        
        if (level.equals(Level.INFO) && logger.isInfoEnabled()) {
            logger.info(msg, ta);
        }
        
        if (level.equals(Level.TRACE) && logger.isTraceEnabled()) {
            logger.trace(msg, ta);
        }
        
        if (level.equals(Level.WARN) && logger.isWarnEnabled()) {
            logger.warn(msg, ta);
        }
    }

    @Override
    public void printSystemProperties() {
        final Properties properties = System.getProperties();
        
        int maxLength = 0;
        for(final Object key : properties.keySet()) {
            maxLength = Math.max(maxLength, String.valueOf(key).length());
        }
        
        final Enumeration keys = properties.keys();
        while (keys.hasMoreElements()) {
            final String key   = (String) keys.nextElement();
            final String value = (String) properties.get(key);
            this.debug(com.github.naoghuman.lib.logger.core.Logger.class, 
                    String.format("%-" + maxLength + "s", key) + ": " + value); // NOI18N
        }
    }
    
    @Override
    public final void trace(final Class clazz, final String msg) {
        this.trace(clazz, msg, null);
    }

    @Override
    public final void trace(final Class clazz, final String msg, final Throwable ta) {
        DefaultLoggerValidator.requireNonNull(clazz);
        DefaultLoggerValidator.requireNonNull(msg);
        
        final org.apache.logging.log4j.Logger logger = this.getLogger(clazz);
        if (!deactivate && logger.isTraceEnabled()) {
            logger.trace(msg, ta);
        }
    }

    @Override
    public final void warn(final Class clazz, final String msg) {
        this.warn(clazz, msg, null);
    }

    @Override
    public final void warn(final Class clazz, final String msg, final Throwable ta) {
        DefaultLoggerValidator.requireNonNull(clazz);
        DefaultLoggerValidator.requireNonNull(msg);
        
        final org.apache.logging.log4j.Logger logger = this.getLogger(clazz);
        if (!deactivate && logger.isWarnEnabled()) {
            logger.warn(msg, ta);
        }
    }
    
}

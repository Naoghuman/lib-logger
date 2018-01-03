/**
 * Copyright (C) 2017 Naoghuman
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

import java.util.HashMap;
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
        DefaultLoggerValidator.requireNonNull(clazz);
        
        this.debug(clazz, msg, null);
    }

    @Override
    public final void debug(final Class clazz, final String msg, final Throwable ta) {
        DefaultLoggerValidator.requireNonNull(clazz);
        
        if (!deactivate && this.getLogger(clazz).isDebugEnabled()) {
            this.getLogger(clazz).debug(msg, ta);
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
        DefaultLoggerValidator.requireNonNull(clazz);
        
        this.error(clazz, msg, null);
    }

    @Override
    public final void error(final Class clazz, final String msg, final Throwable ta) {
        DefaultLoggerValidator.requireNonNull(clazz);
        
        if (!deactivate && this.getLogger(clazz).isErrorEnabled()) {
            this.getLogger(clazz).error(msg, ta);
        }
    }

    @Override
    public final void info(final Class clazz, final String msg) {
        DefaultLoggerValidator.requireNonNull(clazz);
        
        this.info(clazz, msg, null);
    }

    @Override
    public final void info(final Class clazz, final String msg, final Throwable ta) {
        DefaultLoggerValidator.requireNonNull(clazz);
        
        if (!deactivate && this.getLogger(clazz).isInfoEnabled()) {
            this.getLogger(clazz).info(msg, ta);
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
        
        this.getLogger(com.github.naoghuman.lib.logger.core.Logger.class).info(msg.toString());
    }

    @Override
    public final void own(final Class clazz, final String msg) {
        DefaultLoggerValidator.requireNonNull(clazz);
        
        this.own(clazz, msg, null);
    }

    @Override
    public final void own(final Class clazz, final String msg, final Throwable ta) {
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
    public final void trace(final Class clazz, final String msg) {
        DefaultLoggerValidator.requireNonNull(clazz);
        
        this.trace(clazz, msg, null);
    }

    @Override
    public final void trace(final Class clazz, final String msg, final Throwable ta) {
        DefaultLoggerValidator.requireNonNull(clazz);
        
        if (!deactivate && this.getLogger(clazz).isTraceEnabled()) {
            this.getLogger(clazz).trace(msg, ta);
        }
    }

    @Override
    public final void warn(final Class clazz, final String msg) {
        DefaultLoggerValidator.requireNonNull(clazz);
        
        this.warn(clazz, msg, null);
    }

    @Override
    public final void warn(final Class clazz, final String msg, final Throwable ta) {
        DefaultLoggerValidator.requireNonNull(clazz);
        
        if (!deactivate && this.getLogger(clazz).isWarnEnabled()) {
            this.getLogger(clazz).warn(msg, ta);
        }
    }
    
}

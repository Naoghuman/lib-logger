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

import com.github.naoghuman.lib.logger.internal.DefaultLogger;
import java.util.Optional;
import org.apache.logging.log4j.Level;

/**
 * The facade {@link com.github.naoghuman.lib.logger.core.LoggerFacade} provides 
 * access to the logging methods during the {@code Interface} 
 * {@link com.github.naoghuman.lib.logger.core.Logger}.
 *
 * @author Naoghuman
 * @see    com.github.naoghuman.lib.logger.core.Logger
 */
public final class LoggerFacade implements Logger {
    
    private static final Optional<LoggerFacade> instance = Optional.of(new LoggerFacade());

    /**
     * Returns a singleton instance from the class {@code LoggerFacade}.
     * 
     * @return a singleton instance from the class {@code LoggerFacade}.
     */
    public static final LoggerFacade getDefault() {
        return instance.get();
    }
    
    private Logger logger = null;
    
    private LoggerFacade() {
        this.initialize();
    }
    
    private void initialize() {
        logger = new DefaultLogger();
    }

    @Override
    public final void deactivate(final Boolean deactivate) {
        logger.deactivate(deactivate);
    }

    @Override
    public final void debug(final Class clazz, final String msg) {
        logger.debug(clazz, msg);
    }

    @Override
    public final void debug(final Class clazz, final String msg, final Throwable ta) {
        logger.debug(clazz, msg, ta);
    }

    @Override
    public final void define(final Level level) {
        logger.define(level);
    }

    @Override
    public final void error(final Class clazz, final String msg) {
        logger.error(clazz, msg);
    }

    @Override
    public final void error(final Class clazz, final String msg, final Throwable ta) {
        logger.error(clazz, msg, ta);
    }

    @Override
    public final void info(final Class clazz, final String msg) {
        logger.info(clazz, msg);
    }

    @Override
    public final void info(final Class clazz, final String msg, final Throwable ta) {
        logger.info(clazz, msg, ta);
    }

    @Override
    public final void message(final char borderSign, final int borderSignCount, final String figlet) {
        logger.message(borderSign, borderSignCount, figlet);
    }

    @Override
    public final void own(final Class clazz, final String msg) {
        logger.own(clazz, msg);
    }

    @Override
    public final void own(final Class clazz, final String msg, final Throwable ta) {
        logger.own(clazz, msg, ta);
    }

    @Override
    public void printSystemProperties() {
        logger.printSystemProperties();
    }
    
    @Override
    public final void trace(final Class clazz, final String msg) {
        logger.trace(clazz, msg);
    }

    @Override
    public final void trace(final Class clazz, final String msg, final Throwable ta) {
        logger.trace(clazz, msg, ta);
    }

    @Override
    public final void warn(final Class clazz, final String msg) {
        logger.warn(clazz, msg);
    }

    @Override
    public final void warn(final Class clazz, final String msg, final Throwable ta) {
        logger.warn(clazz, msg, ta);
    }
    
}

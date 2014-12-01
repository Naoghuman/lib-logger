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

import de.pro.lib.logger.api.ILogger;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The implementation from the Interface {@link de.pro.lib.logger.api.ILogger}.<br />
 * Access to this class is over the facade {@link de.pro.lib.logger.api.LoggerFacade}.
 * 
 * @author PRo
 * @see de.pro.lib.logger.api.ILogger
 * @see de.pro.lib.logger.api.LoggerFacade
 */
public final class PRoLogger implements ILogger {
    
    private final HashMap<Class, Logger> loggers = new HashMap<>();
    
    private Boolean deactivate = Boolean.FALSE;
    
    /**
     * Default contructor.
     */
    public PRoLogger() { }
    
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
        if (!deactivate) {
            this.getLogger(clazz).debug(msg, ta);
        }
    }

    @Override
    public void error(Class clazz, String msg) {
        this.error(clazz, msg, null);
    }

    @Override
    public void error(Class clazz, String msg, Throwable ta) {
        if (!deactivate) {
            this.getLogger(clazz).error(msg, ta);
        }
    }

    @Override
    public void info(Class clazz, String msg) {
        this.info(clazz, msg, null);
    }

    @Override
    public void info(Class clazz, String msg, Throwable ta) {
        if (!deactivate) {
            this.getLogger(clazz).info(msg, ta);
        }
    }

    @Override
    public void warn(Class clazz, String msg) {
        this.warn(clazz, msg, null);
    }

    @Override
    public void warn(Class clazz, String msg, Throwable ta) {
        if (!deactivate) {
            this.getLogger(clazz).warn(msg, ta);
        }
    }

    @Override
    public void sayWelcome(String welcomeMessage) {
        final StringBuilder msg = new StringBuilder();
        msg.append("# "); // NOI18N
        msg.append(welcomeMessage);
        if (welcomeMessage.length() < 65) {
            for (int i = welcomeMessage.length(); i < 65; i++) {
                msg.append(" "); // NOI18N
            }
        }
        msg.append(" #"); // NOI18N
        
        this.getLogger(PRoLogger.class).info("#####################################################################"); // NOI18N
        this.getLogger(PRoLogger.class).info(msg.toString());
        this.getLogger(PRoLogger.class).info("#####################################################################"); // NOI18N
    
    }

    @Override
    public void sayGoodbye(String goodbyeMessage) {
        final StringBuilder msg = new StringBuilder();
        msg.append("# "); // NOI18N
        msg.append(goodbyeMessage);
        if (goodbyeMessage.length() < 65) {
            for (int i = goodbyeMessage.length(); i < 65; i++) {
                msg.append(" "); // NOI18N
            }
        }
        msg.append(" #"); // NOI18N
        
        
        this.getLogger(PRoLogger.class).info("#####################################################################"); // NOI18N
        this.getLogger(PRoLogger.class).info(msg.toString());
        this.getLogger(PRoLogger.class).info("#####################################################################"); // NOI18N
    }
    
}

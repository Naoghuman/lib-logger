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

/**
 * The facade {@link de.pro.lib.logger.api.LoggerFacade} provides access to
 * the Interface {@link de.pro.lib.logger.api.ILibLogger}.
 *
 * @author PRo
 * @see de.pro.lib.logger.api.ILibLogger
 */
public enum LoggerFacade {
    
    INSTANCE;
    
    private ILibLogger logger = null;
    
    private LoggerFacade() {
        this.initialize();
    }
    
    private void initialize() {
        logger = new LibLogger();
    }
    
    /**
     * Over the {@link de.pro.lib.logger.api.ILibLogger} have the developer 
     * access to the logging methods.
     * 
     * @return a singleton instance from ILibLogger.
     */
    public ILibLogger getLogger() {
        return logger;
    }
    
}

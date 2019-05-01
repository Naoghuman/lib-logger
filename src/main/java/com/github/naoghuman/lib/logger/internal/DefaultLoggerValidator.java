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

import java.util.Objects;

/**
 * This {@code Interface} contains a method to validate if an 
 * {@link java.lang.Object} conforms specific behaviours or not. For example if 
 * an {@code Object} is NULL or not.
 *
 * @since   0.6.0
 * @version 0.7.0
 * @author  Naoghuman
 */
public final class DefaultLoggerValidator {
    
    /**
     * Validates if the parameter {@code value} isn't NULL.
     *
     * @param value the attribute which should be validated.
     * @param <T>   the type of the reference.
     * @since   0.6.0
     * @version 0.7.0
     * @author  Naoghuman
     * @throws  NullPointerException if (value == NULL).
     */
    public static <T> void requireNonNull(T value) throws NullPointerException {
        Objects.requireNonNull(value, "The parameter [value] can't be NULL"); // NOI18N
    }
    
}

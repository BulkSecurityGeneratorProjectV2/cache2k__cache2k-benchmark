package org.cache2k.benchmark.impl2015;

/*
 * #%L
 * zoo
 * %%
 * Copyright (C) 2013 - 2016 headissue GmbH, Munich
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

/**
 * We use instances of the exception wrapper for the value field in the entry.
 * This way we can store exceptions without needing additional memory, if no exceptions
 * happen.
 *
 * @author Jens Wilke; created: 2013-07-12
 */
public class ExceptionWrapper {

  Throwable exception;

  /**
   * Store an additional exception message with the expiry time.
   * Gets lazily set as soon as an exception is thrown.
   */
  transient String additionalExceptionMessage = null;

  public ExceptionWrapper(Throwable ex) {
    exception = ex;
  }

  public Throwable getException() {
    return exception;
  }

  public String toString() {
    return exception.toString();
  }

}

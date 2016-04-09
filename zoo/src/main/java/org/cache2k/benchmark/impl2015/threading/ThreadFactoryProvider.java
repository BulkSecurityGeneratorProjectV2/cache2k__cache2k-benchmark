package org.cache2k.benchmark.impl2015.threading;

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

import org.cache2k.benchmark.impl2015.util.TunableConstants;

import java.util.Properties;
import java.util.concurrent.ThreadFactory;

/**
 * Provider interface for a thread factory. This makes it possible to change
 * the thread factory via the {@link TunableConstants}.
 *
 * @author Jens Wilke; created: 2014-06-10
 */
public interface ThreadFactoryProvider {

  /**
   * Construct a new thread factory for the pool.
   */
  ThreadFactory newThreadFactory(Properties _managerProperties, String namePrefix);

}

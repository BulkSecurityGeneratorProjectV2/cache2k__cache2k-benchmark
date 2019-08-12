package org.cache2k.benchmark.impl2015;

/*
 * #%L
 * Benchmarks: Implementation and eviction variants
 * %%
 * Copyright (C) 2013 - 2019 headissue GmbH, Munich
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.cache2k.CacheException;

/**
 * Wraps an application exception.
 *
 * If a cache receives an exception when fetching a value via the
 * cache source it may propagate the exception wrapped into this
 * one to the caller. Whether propagation occurs depends on the
 * configuration and on the presence of valid data.
 *
 * @author Jens Wilke
 */
public class PropagatedCacheException extends CacheException {

  public PropagatedCacheException(String _message, Throwable ex) {
    super(_message, ex);
  }

  public PropagatedCacheException(Throwable ex) {
    super(ex);
  }

}

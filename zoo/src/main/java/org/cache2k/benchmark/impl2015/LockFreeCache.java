package org.cache2k.benchmark.impl2015;

/*
 * #%L
 * Benchmarks: implementation variants
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

/**
 * @author Jens Wilke; created: 2013-12-22
 */
public abstract class LockFreeCache<E extends Entry, K, T>
  extends BaseCache<E, K, T> {

  /**
   * No locking needed.
   */
  @Override
  protected final void recordHitLocked(E e) {
    recordHit(e);
  }

  /**
   * First lookup in the hash unsynchronized, if missed, do synchronize and
   * try again.
   */
  @Override
  protected final E lookupOrNewEntrySynchronized(K key) {
    int hc = modifiedHash(key.hashCode());
    E e = Hash.lookup(mainHash, key, hc);
    if (e != null) {
      recordHit(e);
      return e;
    }
    synchronized (lock) {
      e = lookupEntry(key, hc);
      if (e == null) {
        e = newEntry(key, hc);
        return e;
      }
      return e;
    }
  }

  @Override
  protected final E lookupEntryUnsynchronized(K key, int hc) {
    E e = Hash.lookup(mainHash, key, hc);
    if (e != null) {
      recordHit(e);
      return e;
    }
    return null;
  }

}

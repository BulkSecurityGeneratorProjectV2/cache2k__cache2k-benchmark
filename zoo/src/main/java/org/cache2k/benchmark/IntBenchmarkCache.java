package org.cache2k.benchmark;

/*
 * #%L
 * Benchmarks: implementation variants
 * %%
 * Copyright (C) 2013 - 2018 headissue GmbH, Munich
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
 * Specialized version with int cache key.
 *
 * @author Jens Wilke
 */
public abstract class IntBenchmarkCache<V> extends BenchmarkCache<Integer, V> {

  /**
   * If the cache does not natively support integer key, just wrap.
   */
  public static <K, V> BenchmarkCache<K, V> wrap(final BenchmarkCache<K, V> c) {
    return (BenchmarkCache<K, V> ) wrapToInt((BenchmarkCache<Integer, V>) c);
  }

  public static <V> IntBenchmarkCache<V> wrapToInt(final BenchmarkCache<Integer, V> c) {
    return new IntBenchmarkCache<V>() {
      @Override
      public V getIfPresent(final Integer key) {
        return c.getIfPresent(key);
      }

      @Override
      public void put(final Integer key, final V value) {
        c.put(key, value);
      }

      @Override
      public void close() {
        c.close();
      }

      @Override
      public int getCacheSize() {
        return c.getCacheSize();
      }

      @Override
      public String toString() {
        return c.toString();
      }
    };
  }

  /**
   * Return the element that is present in the cache. The cache source will not be called in turn.
   */
  public V getIfPresent(Integer key) {
    return getIfPresent((int) key);
  }

  /**
   * Puts an entry in the cache. Needed for read/write benchmark.
   */
  public void put(Integer key, V value) {
    put((int) key, value);
  }

  /**
   * Return the element that is present in the cache. The cache source will not be called in turn.
   */
  public V getIfPresent(int key) {
    return getIfPresent((Integer) key);
  }

  /**
   * Puts an entry in the cache. Needed for read/write benchmark.
   */
  public void put(int key, V value) {
    put((Integer) key, value);
  }

}

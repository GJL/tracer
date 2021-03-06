package org.zalando.tracer;

/*
 * ⁣​
 * Tracer
 * ⁣⁣
 * Copyright (C) 2015 Zalando SE
 * ⁣⁣
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
 * ​⁣
 */

import org.junit.Test;

import static java.util.Arrays.asList;

public final class DefaultTracerTest extends AbstractTracerTest {

    private final Tracer tracer = Tracer.builder()
            .traces(asList("X-Trace-ID", "X-Request-ID"))
            .trace("X-Foo-ID", () -> "foo")
            .build();

    @Override
    protected Tracer unit() {
        return tracer;
    }

    @Test(expected = IllegalStateException.class)
    public void shouldFailToStartWithoutProvidedValuesIfAlreadyStarted() {
        tracer.start();
        tracer.start();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldFailToStartWithProvidedValuesIfAlreadyStarted() {
        tracer.start(trace -> "foo");
        tracer.start(trace -> "bar");
    }

}
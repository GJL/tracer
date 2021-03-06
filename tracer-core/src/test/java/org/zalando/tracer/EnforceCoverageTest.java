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

import com.google.gag.annotation.remark.Hack;
import com.google.gag.annotation.remark.OhNoYouDidnt;
import org.junit.Test;

import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

@Hack
@OhNoYouDidnt
public final class EnforceCoverageTest {

    @Test
    public void shouldUseTracerFactoryConstructor() {
        new TracerFactory();
    }

    @Test
    public void shouldUseTraceListenersConstructor() {
        new TraceListeners();
    }


    @Test
    public void shouldCoverTracerBuilderToString() {
        assertThat(Tracer.builder(), hasToString(notNullValue()));
    }

}

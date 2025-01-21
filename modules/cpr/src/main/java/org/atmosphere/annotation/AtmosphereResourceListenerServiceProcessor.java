/*
 * Copyright 2008-2025 Async-IO.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.atmosphere.annotation;

import org.atmosphere.config.AtmosphereAnnotation;
import org.atmosphere.config.service.AsyncSupportListenerService;
import org.atmosphere.config.service.AtmosphereResourceListenerService;
import org.atmosphere.cpr.AsyncSupportListener;
import org.atmosphere.cpr.AtmosphereFramework;
import org.atmosphere.cpr.AtmosphereResourceListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AtmosphereAnnotation(AtmosphereResourceListenerService.class)
public class AtmosphereResourceListenerServiceProcessor implements Processor<AtmosphereResourceListener> {

    private static final Logger logger = LoggerFactory.getLogger(AtmosphereResourceListenerServiceProcessor.class);

    @Override
    public void handle(AtmosphereFramework framework, Class<AtmosphereResourceListener> annotatedClass) {
        try {
            framework.atmosphereResourceListener(framework.newClassInstance(AtmosphereResourceListener.class, annotatedClass));
        } catch (Throwable e) {
            logger.warn("", e);
        }
    }
}

/*
 * Copyright 2023 Amazon.com, Inc. or its affiliates.
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package software.amazon.lambda.powertools.logging.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.lambda.powertools.logging.Logging;

public class PowertoolsLogSamplingEnabled implements RequestHandler<Object, Boolean> {
    private final Logger LOG = LoggerFactory.getLogger(PowertoolsLogSamplingEnabled.class);

    @Override
    @Logging(samplingRate = 1.0)
    public Boolean handleRequest(Object input, Context context) {
        LOG.info("Test event");
        LOG.debug("Test debug event");
        return LOG.isDebugEnabled();
    }
}

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

package software.amazon.lambda.powertools.idempotency.exceptions;

import java.util.Optional;

import software.amazon.lambda.powertools.idempotency.persistence.DataRecord;

/**
 * Exception thrown when trying to store an item which already exists.
 */
public class IdempotencyItemAlreadyExistsException extends RuntimeException {
    private static final long serialVersionUID = 9027152772149436500L;
    // transient because we don't want to accidentally dump any payloads in logs / stack traces
    private transient Optional<DataRecord> dr = Optional.empty();

    public IdempotencyItemAlreadyExistsException() {
        super();
    }

    public IdempotencyItemAlreadyExistsException(String msg, Throwable e) {
        super(msg, e);
    }

    public IdempotencyItemAlreadyExistsException(String msg, Throwable e, DataRecord dr) {
        super(msg, e);
        this.dr = Optional.ofNullable(dr);
    }

    public Optional<DataRecord> getDataRecord() {
        return dr;
    }
}

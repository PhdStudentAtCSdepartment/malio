/*
 * Copyright © 2023 Frank Hossfeld, Philipp Kohl
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.nalukit.malio.processor.model;

public enum ConstraintType {
  MAX_VALUE_CONSTRAINT,
  MIN_VALUE_CONSTRAINT,
  BLACKLIST_CONSTRAINT,
  WHITELIST_CONSTRAINT,
  REGEXP_CONSTRAINT,
  MAX_LENGTH_CONSTRAINT,
  MIN_LENGTH_CONSTRAINT,
  EMAIL_CONSTRAINT,
  UUID_CONSTRAINT,
  MAX_DECIMAL_VALUE_CONSTRAINT,
  MIN_DECIMAL_VALUE_CONSTRAINT,
  NOT_BLANK_CONSTRAINT,
  NOT_EMPTY_CONSTRAINT,
  SIZE_CONSTRAINT,
  NOT_NULL_CONSTRAINT
}

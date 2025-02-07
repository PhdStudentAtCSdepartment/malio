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
package com.github.nalukit.malio.test;

import com.github.nalukit.malio.shared.messages.LocalizedMessages;
import com.github.nalukit.malio.shared.messages.locales.MessagesEN;
import com.github.nalukit.malio.shared.model.ValidationResult;
import com.github.nalukit.malio.shared.util.MalioValidationException;
import com.github.nalukit.malio.test.model.notnull07.Address;
import com.github.nalukit.malio.test.model.notnull07.Person;
import com.github.nalukit.malio.test.model.notnull07.PersonMalioValidator;
import com.google.gwt.junit.client.GWTTestCase;
import org.junit.Test;

public class ValidatorNotNull07Test
    extends GWTTestCase {

  @Override
  public void gwtSetUp() {
    LocalizedMessages.INSTANCE.setMessages(new MessagesEN());
  }

  @Override
  public String getModuleName() {
    return "com.github.nalukit.malio.MalioGwt2Test";
  }

  @Test
  public void testCheckOkOnDeeperClassHierarchy()
      throws MalioValidationException {
    Person model = new Person(new Address("Test Avenue 21",
                                          "123456",
                                          "Test City"));
    PersonMalioValidator.INSTANCE.check(model);
  }

  @Test
  public void testValidateOkOnDeeperClassHierarchy() {
    Person model = new Person(new Address("Test Avenue 21",
                                          "123456",
                                          "Test City"));
    ValidationResult result = PersonMalioValidator.INSTANCE.validate(model);
    assertTrue(result.isValid());
  }

}

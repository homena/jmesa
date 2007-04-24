/*
 * Copyright 2004 original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jmesa.core.preference;

import static org.junit.Assert.*;

import org.jmesa.core.preference.Preferences;
import org.jmesa.core.preference.PropertiesPreferences;
import org.jmesa.test.AbstractTestCase;
import org.jmesa.web.WebContext;
import org.junit.Test;

/**
 * @since 2.0
 * @author Jeff Johnston
 */
public class PreferencesTest extends AbstractTestCase {
    @Test
    public void getPreference() {
        WebContext webContext = createWebContext();
        Preferences preferences = new PropertiesPreferences("/org/jmesa/core/preference/test.properties", webContext);
        String preference = preferences.getPreference("test.data");
        assertNotNull(preference);
        assertTrue(preference.equals("foo"));
    }
}

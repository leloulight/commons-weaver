/*
 *  Copyright the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.commons.weaver.privilizer.example;

public class Utils {
    public static class More {
        private More() {
        }

        public static String getProperty() {
            return Utils.getProperty("bar");
        }

        public static String getTopStackElementClassName() {
            return Thread.currentThread().getStackTrace()[1].getClassName();
        }
    }

    private Utils() {
    }

    public static String getProperty() {
        return getProperty("foo");
    }

    public static String getProperty(int i, String key) {
        if (i <= 0) {
            return getProperty(key);
        }
        return getProperty(--i, key);
    }

    public static String getProperty(String key) {
        return System.getProperty(key);
    }
}

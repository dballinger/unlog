/*
 * Copyright 2013 Aaron Knauf
 *
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
 */

package com.github.unlog.internal.format;

abstract class AbstractParseState implements ParseState {

    @Override
    public ParseState parseNextCharacter(char c, CamelCasePhrase.ElementBuilder builder) {
        if (Character.isUpperCase(c)) {
            return parseUpperCase(c, builder);
        } else if (Character.isLowerCase(c)) {
            return parseLowerCase(c, builder);
        } else {
            return parseOther(c, builder);
        }
    }

    protected ParseState parseOther(char c, CamelCasePhrase.ElementBuilder builder) {
        builder.addCharToElement(c);
        return this;
    }

    protected ParseState parseUpperCase(char c, CamelCasePhrase.ElementBuilder builder) {
        return parseOther(c, builder);
    }

    protected ParseState parseLowerCase(char c, CamelCasePhrase.ElementBuilder builder) {
        return parseOther(c, builder);
    }
}
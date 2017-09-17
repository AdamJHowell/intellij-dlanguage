/*
 * Files adapted from the go-lang-idea-plugin project at,
 *  https://github.com/go-lang-plugin-org/go-lang-idea-plugin
 * Original copyright from the golang idea plugin:
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package uk.co.cwspencer.gdb.gdbmi;

/**
 * Class representing a token read from a GDB/MI stream.
 */
public class GdbMiToken {
    /**
     * The type of token.
     */
    public Type type;
    /**
     * The token value, if any.
     */
    public String value = null;

    /**
     * Constructor; sets the values.
     *
     * @param type  The type of the token.
     * @param value The value of the token.
     */
    public GdbMiToken(Type type, String value) {
        this.type = type;
        this.value = value;
    }

    /**
     * Constructor; sets the type. The value is set to null.
     *
     * @param type The type of token.
     */
    public GdbMiToken(Type type) {
        this.type = type;
    }

    /**
     * Converts the token to a string.
     *
     * @return A string containing the type and, if set, the value.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(type);
        if (value != null) {
            sb.append(": ");
            sb.append(value);
        }
        return sb.toString();
    }

    /**
     * Possible token types.
     */
    public enum Type {
        UserToken,                  // String of digits
        ResultRecordPrefix,         // "^"
        ExecAsyncOutputPrefix,      // "*"
        StatusAsyncOutputPrefix,    // "+"
        NotifyAsyncOutputPrefix,    // "="
        ConsoleStreamOutputPrefix,  // "~"
        TargetStreamOutputPrefix,   // "@"
        LogStreamOutputPrefix,      // "&"
        Identifier,                 // result-class or async-class
        Equals,                     // "="
        ResultSeparator,            // ","
        StringPrefix,               // """
        StringFragment,             // Part of a string
        StringEscapePrefix,         // "\"
        StringEscapeApostrophe,     // "'"
        StringEscapeQuote,          // """
        StringEscapeQuestion,       // "?"
        StringEscapeBackslash,      // "\"
        StringEscapeAlarm,          // "a"
        StringEscapeBackspace,      // "b"
        StringEscapeFormFeed,       // "f"
        StringEscapeNewLine,        // "n"
        StringEscapeCarriageReturn, // "r"
        StringEscapeHorizontalTab,  // "t"
        StringEscapeVerticalTab,    // "v"
        StringEscapeHexPrefix,      // "x"
        StringEscapeHexValue,       // 1-* hexadecimal digits
        StringEscapeOctValue,       // 1-3 octal digits
        StringSuffix,               // """
        TuplePrefix,                // "{"
        TupleSuffix,                // "}"
        ListPrefix,                 // "["
        ListSuffix,                 // "]"
        NewLine,                    // "\r" or "\r\n"
        GdbSuffix                   // "(gdb)"
    }
}

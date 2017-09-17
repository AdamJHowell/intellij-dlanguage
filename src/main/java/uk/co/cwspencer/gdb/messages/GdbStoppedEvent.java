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

package uk.co.cwspencer.gdb.messages;

import uk.co.cwspencer.gdb.gdbmi.GdbMiRecord;
import uk.co.cwspencer.gdb.gdbmi.GdbMiValue;
import uk.co.cwspencer.gdb.messages.annotations.GdbMiEnum;
import uk.co.cwspencer.gdb.messages.annotations.GdbMiEvent;
import uk.co.cwspencer.gdb.messages.annotations.GdbMiField;

import java.util.List;

/**
 * Event fired when the target application stops.
 */
@SuppressWarnings("unused")
@GdbMiEvent(recordType = GdbMiRecord.Type.Exec, className = "stopped")
public class GdbStoppedEvent extends GdbEvent {
    /**
     * The reason the target stopped.
     */
    @GdbMiField(name = "reason", valueType = GdbMiValue.Type.String)
    public Reason reason;
    /**
     * The breakpoint disposition.
     */
    @GdbMiField(name = "disp", valueType = GdbMiValue.Type.String)
    public GdbBreakpoint.BreakpointDisposition breakpointDisposition;
    /**
     * The breakpoint number.
     */
    @GdbMiField(name = "bkptno", valueType = GdbMiValue.Type.String)
    public Integer breakpointNumber;
    /**
     * The current point of execution.
     */
    @GdbMiField(name = "frame", valueType = GdbMiValue.Type.Tuple)
    public GdbStackFrame frame;
    /**
     * The thread of execution.
     */
    @GdbMiField(name = "thread-id", valueType = GdbMiValue.Type.String)
    public Integer threadId;
    /**
     * Flag indicating whether all threads were stopped. If false, stoppedThreads contains a list of
     * the threads that were stopped.
     */
    @GdbMiField(name = "stopped-threads",
        valueType = {GdbMiValue.Type.String, GdbMiValue.Type.List},
        valueProcessor = "uk.co.cwspencer.gdb.messages.GdbMiMessageConverterUtils.valueIsAll")
    public Boolean allStopped;
    /**
     * A list of the threads that were stopped. This will be null if allStopped is true.
     */
    @GdbMiField(name = "stopped-threads",
        valueType = {GdbMiValue.Type.String, GdbMiValue.Type.List}, valueProcessor =
        "uk.co.cwspencer.gdb.messages.GdbMiMessageConverterUtils.passThroughIfNotAll")
    public List<Integer> stoppedThreads;

    /**
     * Possible reasons that can cause the program to stop.
     */
    @GdbMiEnum
    public enum Reason {
        BreakpointHit,
        WatchpointTrigger,
        ReadWatchpointTrigger,
        AccessWatchpointTrigger,
        FunctionFinished,
        LocationReached,
        WatchpointScope,
        EndSteppingRange,
        ExitedSignalled,
        Exited,
        ExitedNormally,
        SignalReceived,
        SolibEvent,
        Fork,
        Vfork,
        SyscallEntry,
        Exec
    }
}

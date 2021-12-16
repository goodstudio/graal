/*
 * Copyright (c) 2021, 2021, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package com.oracle.svm.core.thread;

import java.util.concurrent.ThreadFactory;

import org.graalvm.compiler.api.replacements.Fold;

import com.oracle.svm.core.util.VMError;

class NoVirtualThreads implements VirtualThreads {
    private static RuntimeException unreachable() {
        return VMError.shouldNotReachHere();
    }

    @Fold
    @Override
    public boolean isSupported() {
        return false;
    }

    @Override
    public ThreadFactory createFactory() {
        throw unreachable();
    }

    @Override
    public boolean isVirtual(Thread thread) {
        return false;
    }

    @Override
    public boolean getAndClearInterrupt(Thread thread) {
        throw unreachable();
    }

    @Override
    public void join(Thread thread, long millis) throws InterruptedException {
        throw unreachable();
    }

    @Override
    public void yield() {
        throw unreachable();
    }

    @Override
    public void sleepMillis(long millis) {
        throw unreachable();
    }

    @Override
    public boolean isAlive(Thread thread) {
        throw unreachable();
    }

    @Override
    public void unpark(Thread thread) {
        throw unreachable();
    }

    @Override
    public void park() {
        throw unreachable();
    }

    @Override
    public void parkNanos(long nanos) {
        throw unreachable();
    }

    @Override
    public void parkUntil(long deadline) {
        throw unreachable();
    }

    @Override
    public void pinCurrent() {
        throw unreachable();
    }

    @Override
    public void unpinCurrent() {
        throw unreachable();
    }
}

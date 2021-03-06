/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.core.voice.voiceconsolecommandextension;

import static org.junit.Assert.assertNotNull;

import org.eclipse.smarthome.core.audio.AudioManager;
import org.eclipse.smarthome.core.voice.VoiceManager;
import org.eclipse.smarthome.core.voice.internal.AudioManagerStub;
import org.eclipse.smarthome.core.voice.internal.AudioSourceStub;
import org.eclipse.smarthome.core.voice.internal.ConsoleStub;
import org.eclipse.smarthome.core.voice.internal.SinkStub;
import org.eclipse.smarthome.core.voice.internal.VoiceConsoleCommandExtension;
import org.eclipse.smarthome.core.voice.internal.VoiceManagerImpl;
import org.eclipse.smarthome.io.console.extensions.ConsoleCommandExtension;
import org.eclipse.smarthome.test.java.JavaOSGiTest;
import org.junit.Before;

/**
 * A base class for the classes testing the different commands of the {@link VoiceConsoleCommandExtension}.
 * It takes care of the mocks, stubs and services that are used in all the extending classes.
 *
 * @author Mihaela Memova - initial contribution
 *
 * @author Velin Yordanov - migrated tests from groovy to java
 *
 */
public abstract class VoiceConsoleCommandExtensionTest extends JavaOSGiTest {
    protected VoiceManagerImpl voiceManager;
    protected VoiceConsoleCommandExtension extensionService;
    protected AudioManager audioManager;
    protected ConsoleStub console;
    protected SinkStub sink;
    protected AudioSourceStub source;

    @Before
    public void setup() {
        voiceManager = getService(VoiceManager.class, VoiceManagerImpl.class);
        assertNotNull(voiceManager);

        extensionService = getService(ConsoleCommandExtension.class, VoiceConsoleCommandExtension.class);
        assertNotNull(extensionService);

        sink = new SinkStub();
        source = new AudioSourceStub();
        audioManager = new AudioManagerStub();
        console = new ConsoleStub();

        registerService(audioManager);
        registerService(voiceManager);
    }
}

/**
 * 			NativeFmodEx Project
 *
 * Want to use FMOD Ex API (www.fmod.org) in the Java language ? NativeFmodEx is made for you.
 * Copyright � 2005-2010 J�r�me JOUVIE (Jouvieje)
 *
 * Created on 23 feb. 2005
 * @version file v1.5.0
 * @author J�r�me JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 * 
 * INTRODUCTION
 * FMOD Ex is a music and sound effects system, by Firelight Technologies Pty, Ltd.
 * More informations can be found at:
 * 		http://www.fmod.org/
 * The aim of this project is to provide a java interface for this amazing sound API.
 * 
 * 
 * GNU LESSER GENERAL PUBLIC LICENSE
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1 of the License,
 * or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the
 * Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307 USA 
 */

package org.jouvieje.fmodex;

import org.jouvieje.fmodex.*;
import org.jouvieje.fmodex.exceptions.*;
import org.jouvieje.fmodex.callbacks.*;
import org.jouvieje.fmodex.*;
import org.jouvieje.fmodex.defines.*;
import org.jouvieje.fmodex.enumerations.*;
import org.jouvieje.fmodex.structures.*;
import java.nio.*;
import org.jouvieje.fmodex.utils.*;
import org.jouvieje.fmodex.System;

/**
 * 'DSPConnection' API
 */
public class DSPConnection extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>DSPConnection</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a DSPConnection object.
	 */
	public static DSPConnection asDSPConnection(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new DSPConnection(address);
	}
	private DSPConnection(long pointer) {
		super(pointer);
	}

	public DSPConnection() {
		super(0);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getInput(DSP input) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodExJNI.DSPConnection_getInput(pointer, input);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getOutput(DSP output) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodExJNI.DSPConnection_getOutput(pointer, output);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setMix(float volume) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodExJNI.DSPConnection_setMix(pointer, volume);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getMix(FloatBuffer volume) {
		if(pointer == 0) throw new NullPointerException();
		if(volume != null && !volume.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodExJNI.DSPConnection_getMix(pointer, volume, BufferUtils.getPositionInBytes(volume));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setLevels(FMOD_SPEAKER speaker, FloatBuffer levels, int numlevels) {
		if(pointer == 0) throw new NullPointerException();
		if(levels != null && !levels.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodExJNI.DSPConnection_setLevels(pointer, speaker.asInt(), levels, BufferUtils.getPositionInBytes(levels), numlevels);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getLevels(FMOD_SPEAKER speaker, FloatBuffer levels, int numlevels) {
		if(pointer == 0) throw new NullPointerException();
		if(levels != null && !levels.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodExJNI.DSPConnection_getLevels(pointer, speaker.asInt(), levels, BufferUtils.getPositionInBytes(levels), numlevels);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setUserData(Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodExJNI.DSPConnection_setUserData(pointer, Pointer.getPointer(userdata));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getUserData(Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodExJNI.DSPConnection_getUserData(pointer, userdata);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getMemoryInfo(int memorybits, int event_memorybits, IntBuffer memoryused, FMOD_MEMORY_USAGE_DETAILS memoryused_details) {
		if(pointer == 0) throw new NullPointerException();
		if(memoryused != null && !memoryused.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodExJNI.DSPConnection_getMemoryInfo(pointer, memorybits, event_memorybits, memoryused, BufferUtils.getPositionInBytes(memoryused), Pointer.getPointer(memoryused_details));
		return FMOD_RESULT.get(javaResult);
	}

}

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

package org.jouvieje.fmoddesigner;

import org.jouvieje.fmoddesigner.*;
import org.jouvieje.fmodex.exceptions.*;
import org.jouvieje.fmoddesigner.callbacks.*;
import org.jouvieje.fmoddesigner.*;
import org.jouvieje.fmoddesigner.defines.*;
import org.jouvieje.fmoddesigner.enumerations.*;
import org.jouvieje.fmoddesigner.structures.*;
import java.nio.*;
import org.jouvieje.fmodex.*;
import org.jouvieje.fmodex.System;
import org.jouvieje.fmodex.enumerations.*;
import org.jouvieje.fmodex.structures.*;
import org.jouvieje.fmodex.utils.*;

/**
 * 'MusicPrompt' API
 */
public class MusicPrompt extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>MusicPrompt</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a MusicPrompt object.
	 */
	public static MusicPrompt asMusicPrompt(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new MusicPrompt(address);
	}
	private MusicPrompt(long pointer) {
		super(pointer);
	}

	public MusicPrompt() {
		super(0);
	}

	/**
	 * 
	 */
	public FMOD_RESULT release() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.MusicPrompt_release(pointer);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT begin() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.MusicPrompt_begin(pointer);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT end() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.MusicPrompt_end(pointer);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT isActive(ByteBuffer active) {
		if(pointer == 0) throw new NullPointerException();
		if(active != null && !active.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.MusicPrompt_isActive(pointer, active, BufferUtils.getPositionInBytes(active));
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
		int javaResult = FmodDesignerJNI.MusicPrompt_getMemoryInfo(pointer, memorybits, event_memorybits, memoryused, BufferUtils.getPositionInBytes(memoryused), Pointer.getPointer(memoryused_details));
		return FMOD_RESULT.get(javaResult);
	}

}

/*
PresenceServiceImpl.java
Copyright (C) 2010-2013  Belledonne Communications, Grenoble, France

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
*/

package org.linphone.core;

public class PresenceServiceImpl implements PresenceService {
	private long mNativePtr;

	protected PresenceServiceImpl(long nativePtr) {
		mNativePtr = nativePtr;
	}

	private native long newPresenceServiceImpl(String id);
	protected PresenceServiceImpl(String id) {
		mNativePtr = newPresenceServiceImpl(id);
	}

	private native void unref(long nativePtr);
	protected void finalize() {
		unref(mNativePtr);
	}

	private native int getBasicStatus(long nativePtr);
	@Override
	public PresenceBasicStatus getBasicStatus() {
		return PresenceBasicStatus.fromInt(getBasicStatus(mNativePtr));
	}

	private native int setBasicStatus(long nativePtr, int status);
	@Override
	public int setBasicStatus(PresenceBasicStatus status) {
		return setBasicStatus(mNativePtr, status.toInt());
	}

	private native String getContact(long nativePtr);
	@Override
	public String getContact() {
		return getContact(mNativePtr);
	}

	private native int setContact(long nativePtr, String contact);
	@Override
	public int setContact(String contact) {
		return setContact(mNativePtr, contact);
	}

	public long getNativePtr() {
		return mNativePtr;
	}
}
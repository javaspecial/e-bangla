package com.interface_;

public enum ActionCommand {
	AUTHORIZE, AUTHORIZE_ALL, EDIT_TIPS, VOID_TRANS, TIP_ADJUST, CLOSE, OK;

	public String toString() {
		return name().replaceAll("_", " "); //$NON-NLS-1$ //$NON-NLS-2$
	};
}

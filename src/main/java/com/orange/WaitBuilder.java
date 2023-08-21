package com.orange;

import Utility.DriverManager;

public class WaitBuilder {

	private WaitBuilder() {
	}

	public static NoStaleWait buildNoStaleWait() {
		return new NoStaleWait(DriverManager.getDriver());
	}

}

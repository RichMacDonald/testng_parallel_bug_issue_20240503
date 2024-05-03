package testng.listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * This is a global listener for all testng runs. It exists as a ServiceLoasdfer so it does not need to be specified.
 * (Also means it cannot be turned off.)
 *
 * The main reason for existence is that testng in multi-threaded mode defaults to different threads per METHOD.
 * That means that the same class can be called simultaneously by multiple methods.
 * For some classes that is fine. But for any class that has field attributes, this is bound to cause problems.
 * So we change the default here to CLASSES, which means each class will run in a single-thread.
 * (And if we have many classes being run, we still get parllel thread performance.)
 */

public class TestNgSuiteListener implements ISuiteListener {
	@Override
	public void onStart(ISuite suite) {
		suite.setAttribute("parallel", "classes");
	}
}

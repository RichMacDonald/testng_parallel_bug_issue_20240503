package issue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



/**
 * With the subclass written as a static inner class, the test sequence is out of order
 * Note that TestNGIssue_Parent starts before TestNGIssue_Child_NotOk completes
 *

		beforeClass TestNGIssue_Child_NotOk Thread[#1,main,5,main]
		test1 TestNGIssue_Child_NotOk Thread[#1,main,5,main]
		beforeClass TestNGIssue_Parent Thread[#1,main,5,main]
		test1 TestNGIssue_Parent Thread[#1,main,5,main]
		test2 TestNGIssue_Child_NotOk Thread[#1,main,5,main]
		afterClass TestNGIssue_Child_NotOk Thread[#1,main,5,main]
		test2 TestNGIssue_Parent Thread[#1,main,5,main]
		afterClass TestNGIssue_Parent Thread[#1,main,5,main]

**/


public class TestNGIssue_Parent_NotOk {

	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass " + getClass().getSimpleName() + " " + Thread.currentThread());
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass " + getClass().getSimpleName() + " " +Thread.currentThread());
	}

	@Test
	public void test1() {
		System.out.println("test1 " + getClass().getSimpleName() + " " +Thread.currentThread());
	}

	@Test
	public void test2() {
		System.out.println("test2 " + getClass().getSimpleName() + " " + Thread.currentThread());
	}

	public static class TestNGIssue_Child_NotOk extends TestNGIssue_Parent_NotOk{

	}
}

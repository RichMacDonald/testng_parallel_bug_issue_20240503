package issue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * Running testng on this folder shows the correct operation sequence.
 * Note that TestNGIssue_Parent completes before TestNGIssue_Child starts


		beforeClass TestNGIssue_Child_Ok Thread[#1,main,5,main]
		test1 TestNGIssue_Child_Ok Thread[#1,main,5,main]
		test2 TestNGIssue_Child_Ok Thread[#1,main,5,main]
		afterClass TestNGIssue_Child_Ok Thread[#1,main,5,main]
		beforeClass TestNGIssue_Parent Thread[#1,main,5,main]
		test1 TestNGIssue_Parent Thread[#1,main,5,main]
		test2 TestNGIssue_Parent Thread[#1,main,5,main]
		afterClass TestNGIssue_Parent Thread[#1,main,5,main]

**/


public class TestNGIssue_Parent_Ok {

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
}

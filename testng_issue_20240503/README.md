Refer to https://groups.google.com/g/testng-users/c/KpPqUAzEVSw

This small project indicates an issue with testng running in parallel=classes mode, yet executing different classes in the same
thread but out of order. The problem occurs when:

	1) Using 1 thread.
	2) One class is a static inner class of another.
	3) We select the class (or the folder) to create the eclipse launch file.

The problem does not occur when:

	1) We run the tests on the project using the testng.xml file.
	2) The static inner class to moved to its own file.META-INF
	

Included is a ISuiteListener that sets parallel=classes. However, this does not change the issue.


Executing tests by running the issue src folder in the eclipse environment. Tests run out of order.

beforeClass TestNGIssue_Child_NotOk Thread[#1,main,5,main]
test1 TestNGIssue_Child_NotOk Thread[#1,main,5,main]
beforeClass TestNGIssue_Parent_NotOk Thread[#1,main,5,main]
test1 TestNGIssue_Parent_NotOk Thread[#1,main,5,main]
test2 TestNGIssue_Child_NotOk Thread[#1,main,5,main]
afterClass TestNGIssue_Child_NotOk Thread[#1,main,5,main]
test2 TestNGIssue_Parent_NotOk Thread[#1,main,5,main]
afterClass TestNGIssue_Parent_NotOk Thread[#1,main,5,main]
beforeClass TestNGIssue_Parent_Ok Thread[#1,main,5,main]
test1 TestNGIssue_Parent_Ok Thread[#1,main,5,main]
test2 TestNGIssue_Parent_Ok Thread[#1,main,5,main]
afterClass TestNGIssue_Parent_Ok Thread[#1,main,5,main]
beforeClass TestNGIssue_Child_Ok Thread[#1,main,5,main]
test1 TestNGIssue_Child_Ok Thread[#1,main,5,main]
test2 TestNGIssue_Child_Ok Thread[#1,main,5,main]
afterClass TestNGIssue_Child_Ok Thread[#1,main,5,main]





Executing tests by running testng.xml in the eclipse environment. Everything works correctly.

beforeClass TestNGIssue_Child_Ok Thread[#1,main,5,main]
test1 TestNGIssue_Child_Ok Thread[#1,main,5,main]
test2 TestNGIssue_Child_Ok Thread[#1,main,5,main]
afterClass TestNGIssue_Child_Ok Thread[#1,main,5,main]
beforeClass TestNGIssue_Child_NotOk Thread[#1,main,5,main]
test1 TestNGIssue_Child_NotOk Thread[#1,main,5,main]
test2 TestNGIssue_Child_NotOk Thread[#1,main,5,main]
afterClass TestNGIssue_Child_NotOk Thread[#1,main,5,main]
beforeClass TestNGIssue_Parent_NotOk Thread[#1,main,5,main]
test1 TestNGIssue_Parent_NotOk Thread[#1,main,5,main]
test2 TestNGIssue_Parent_NotOk Thread[#1,main,5,main]
afterClass TestNGIssue_Parent_NotOk Thread[#1,main,5,main]
beforeClass TestNGIssue_Parent_Ok Thread[#1,main,5,main]
test1 TestNGIssue_Parent_Ok Thread[#1,main,5,main]
test2 TestNGIssue_Parent_Ok Thread[#1,main,5,main]
afterClass TestNGIssue_Parent_Ok Thread[#1,main,5,main]
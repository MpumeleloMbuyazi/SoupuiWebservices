package Rest;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.support.SoapUIException;
import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class restTest {

    @Test
    public void multipleTest() throws XmlException, IOException, SoapUIException {
        //Grabs the Project
        WsdlProject project = new WsdlProject("C:\\Users\\mdube\\Documents\\SoupUI\\REST Projects\\Book-Library-REST-Project-soapui-project.xml");
        //Grabs the Testsuite in the project
        WsdlTestSuite testSuite = project.getTestSuiteByName("BookLibrary TestSuite");

        //Grabs the testcases present in the testsuite
        for (int i = 0; i < testSuite.getTestCaseCount(); i++){

            //Run the test cases
            WsdlTestCase testCase = testSuite.getTestCaseAt(i);
            TestRunner runner = testCase.run(new PropertiesMap(), false);
            Assert.assertEquals(TestRunner.Status.FINISHED, runner.getStatus());
        }
    }

    @Test
    public void singleTest() throws XmlException, IOException, SoapUIException {

        //Grabs the Project
        WsdlProject project = new WsdlProject("C:\\Users\\mdube\\Documents\\SoupUI\\REST Projects\\Book-Library-REST-Project-soapui-project.xml");
        //Grabs the Testsuite in the project
        WsdlTestSuite testSuite = project.getTestSuiteByName("BookLibrary TestSuite");

        WsdlTestCase testCase = testSuite.getTestCaseByName("Addbook TestCase");
        WsdlTestCase testCase2 = testSuite.getTestCaseByName("DeleteBook TestCase");

        TestRunner runner = testCase.run(new PropertiesMap(), false);
        TestRunner runner1 = testCase2.run(new PropertiesMap(), false);

        Assert.assertEquals(TestRunner.Status.FINISHED, runner.getStatus());
        Assert.assertEquals(TestRunner.Status.FINISHED, runner1.getStatus());

    }

}

package Soap;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCaseRunner;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestCaseRunner;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.support.SoapUIException;
import org.apache.xmlbeans.XmlException;

import  com.eviware.soapui.model.testsuite.TestRunner.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class soapTestRunner {

    @Test
    public void soapTest() throws XmlException, IOException, SoapUIException {

        //Grabs the Project
        WsdlProject project = new WsdlProject("C:\\Users\\mdube\\Documents\\SoupUI\\EmployeeManagement-Automation-soapui-project.xml");
        //Grabs the Testsuite in the project
        WsdlTestSuite testSuite = project.getTestSuiteByName("TestSuite");

        //Grabs the testcases present in the testsuite
        for (int i = 0; i < testSuite.getTestCaseCount(); i++){

            //Run the test cases
            WsdlTestCase testCase = testSuite.getTestCaseAt(i);
            TestRunner runner = testCase.run(new PropertiesMap(), false);
            Assert.assertEquals(Status.FINISHED, runner.getStatus());
        }

    }
}

$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/Cucumber/Features/StockValues.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: rmani2005@gmail.com"
    }
  ],
  "line": 4,
  "name": "Login to the CNBC site and fetch different stock index",
  "description": "",
  "id": "login-to-the-cnbc-site-and-fetch-different-stock-index",
  "keyword": "Feature",
  "tags": [
    {
      "line": 3,
      "name": "@smoke,"
    },
    {
      "line": 3,
      "name": "@regression"
    }
  ]
});
formatter.scenario({
  "line": 8,
  "name": "login into the CNBC site through Google",
  "description": "",
  "id": "login-to-the-cnbc-site-and-fetch-different-stock-index;login-into-the-cnbc-site-through-google",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@core,"
    },
    {
      "line": 7,
      "name": "@login,"
    },
    {
      "line": 7,
      "name": "@Blocker"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "Open the Chrome browser and maximize it",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "Navigate to test env and test_url site",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Ensure the browser is open and navigate to test_url and CNBC",
  "keyword": "When "
});
formatter.match({
  "location": "stepdefinition.open_the_Chrome_browser_and_maximize_it()"
});
formatter.result({
  "duration": 253417472,
  "error_message": "java.lang.ExceptionInInitializerError\n\tat cucumber.deps.com.thoughtworks.xstream.XStream.setupConverters(XStream.java:820)\n\tat cucumber.deps.com.thoughtworks.xstream.XStream.\u003cinit\u003e(XStream.java:574)\n\tat cucumber.deps.com.thoughtworks.xstream.XStream.\u003cinit\u003e(XStream.java:530)\n\tat cucumber.runtime.xstream.LocalizedXStreams$LocalizedXStream.\u003cinit\u003e(LocalizedXStreams.java:50)\n\tat cucumber.runtime.xstream.LocalizedXStreams.newXStream(LocalizedXStreams.java:37)\n\tat cucumber.runtime.xstream.LocalizedXStreams.get(LocalizedXStreams.java:29)\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:299)\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\n\tat cucumber.api.testng.TestNGCucumberRunner.runCucumber(TestNGCucumberRunner.java:63)\n\tat cucumber.api.testng.AbstractTestNGCucumberTests.feature(AbstractTestNGCucumberTests.java:21)\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:568)\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:133)\n\tat org.testng.internal.TestInvoker.invokeMethod(TestInvoker.java:598)\n\tat org.testng.internal.TestInvoker.invokeTestMethod(TestInvoker.java:173)\n\tat org.testng.internal.MethodRunner.runInSequence(MethodRunner.java:46)\n\tat org.testng.internal.TestInvoker$MethodInvocationAgent.invoke(TestInvoker.java:824)\n\tat org.testng.internal.TestInvoker.invokeTestMethods(TestInvoker.java:146)\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:146)\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:128)\n\tat java.base/java.util.ArrayList.forEach(ArrayList.java:1511)\n\tat org.testng.TestRunner.privateRun(TestRunner.java:794)\n\tat org.testng.TestRunner.run(TestRunner.java:596)\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:377)\n\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:371)\n\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:332)\n\tat org.testng.SuiteRunner.run(SuiteRunner.java:276)\n\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:53)\n\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:96)\n\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1212)\n\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1134)\n\tat org.testng.TestNG.runSuites(TestNG.java:1063)\n\tat org.testng.TestNG.run(TestNG.java:1031)\n\tat org.testng.remote.AbstractRemoteTestNG.run(AbstractRemoteTestNG.java:115)\n\tat org.testng.remote.RemoteTestNG.initAndRun(RemoteTestNG.java:251)\n\tat org.testng.remote.RemoteTestNG.main(RemoteTestNG.java:77)\n\tat ✽.Given Open the Chrome browser and maximize it(src/Cucumber/Features/StockValues.feature:9)\nCaused by: java.lang.reflect.InaccessibleObjectException: Unable to make field private final java.util.Comparator java.util.TreeMap.comparator accessible: module java.base does not \"opens java.util\" to unnamed module @90f6bfd\n\tat java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:354)\n\tat java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:297)\n\tat java.base/java.lang.reflect.Field.checkCanSetAccessible(Field.java:178)\n\tat java.base/java.lang.reflect.Field.setAccessible(Field.java:172)\n\tat cucumber.deps.com.thoughtworks.xstream.core.util.Fields.locate(Fields.java:39)\n\tat cucumber.deps.com.thoughtworks.xstream.converters.collections.TreeMapConverter.\u003cclinit\u003e(TreeMapConverter.java:50)\n\tat cucumber.deps.com.thoughtworks.xstream.XStream.setupConverters(XStream.java:820)\n\tat cucumber.deps.com.thoughtworks.xstream.XStream.\u003cinit\u003e(XStream.java:574)\n\tat cucumber.deps.com.thoughtworks.xstream.XStream.\u003cinit\u003e(XStream.java:530)\n\tat cucumber.runtime.xstream.LocalizedXStreams$LocalizedXStream.\u003cinit\u003e(LocalizedXStreams.java:50)\n\tat cucumber.runtime.xstream.LocalizedXStreams.newXStream(LocalizedXStreams.java:37)\n\tat cucumber.runtime.xstream.LocalizedXStreams.get(LocalizedXStreams.java:29)\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:299)\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\n\tat cucumber.api.testng.TestNGCucumberRunner.runCucumber(TestNGCucumberRunner.java:63)\n\tat cucumber.api.testng.AbstractTestNGCucumberTests.feature(AbstractTestNGCucumberTests.java:21)\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:568)\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:133)\n\tat org.testng.internal.TestInvoker.invokeMethod(TestInvoker.java:598)\n\tat org.testng.internal.TestInvoker.invokeTestMethod(TestInvoker.java:173)\n\tat org.testng.internal.MethodRunner.runInSequence(MethodRunner.java:46)\n\tat org.testng.internal.TestInvoker$MethodInvocationAgent.invoke(TestInvoker.java:824)\n\tat org.testng.internal.TestInvoker.invokeTestMethods(TestInvoker.java:146)\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:146)\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:128)\n\tat java.base/java.util.ArrayList.forEach(ArrayList.java:1511)\n\tat org.testng.TestRunner.privateRun(TestRunner.java:794)\n\tat org.testng.TestRunner.run(TestRunner.java:596)\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:377)\n\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:371)\n\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:332)\n\tat org.testng.SuiteRunner.run(SuiteRunner.java:276)\n\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:53)\n\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:96)\n\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1212)\n\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1134)\n\tat org.testng.TestNG.runSuites(TestNG.java:1063)\n\tat org.testng.TestNG.run(TestNG.java:1031)\n\tat org.testng.remote.AbstractRemoteTestNG.run(AbstractRemoteTestNG.java:115)\n\tat org.testng.remote.RemoteTestNG.initAndRun(RemoteTestNG.java:251)\n\tat org.testng.remote.RemoteTestNG.main(RemoteTestNG.java:77)\n",
  "status": "failed"
});
formatter.match({
  "location": "stepdefinition.navigate_to_test_env_and_test_url_site()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepdefinition.ensure_the_browser_is_open_and_navigate_to_test_url_and_CNBC()"
});
formatter.result({
  "status": "skipped"
});
});
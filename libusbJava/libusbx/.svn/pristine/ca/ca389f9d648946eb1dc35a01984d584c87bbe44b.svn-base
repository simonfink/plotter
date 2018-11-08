@ECHO OFF
ECHO Executing LibusbJava Tests:

REM ECHO AllMpc555BdiTests:
REM ECHO ------------------
REM java -cp "C:\Program Files\Java\junit4\junit-4.12.jar";"C:\Program Files\Java\junit4\hamcrest-core-1.3.jar";build64\java\test\LibusbJavaJunitTest.jar;build64\java\src\LibusbJava.jar org.junit.runner.JUnitCore ch.ntb.inf.libusb.test.junit.mpc555Bdi.AllMpc555BdiTests

call:runJunitTest Mpc555BdiDeviceTest
call:runJunitTest DescriptorTest

GOTO:EOF

:: function to execute junit test
:runJunitTest
ECHO %~1 
ECHO ---------------------------------
java -cp "C:\Program Files\Java\junit4\junit-4.12.jar";"C:\Program Files\Java\junit4\hamcrest-core-1.3.jar";build64\java\test\LibusbJavaJunitTest.jar;build64\java\src\LibusbJava.jar org.junit.runner.JUnitCore ch.ntb.inf.libusb.test.junit.mpc555Bdi.%~1
EXIT /B 0

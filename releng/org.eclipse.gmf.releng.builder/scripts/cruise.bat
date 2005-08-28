@echo off
rem You must have the variable CC_HOME set pointing to the CruiseControl installation directory
rem Make log directory structure (assuming defaults, TODO: put in Ant when CC uses properties)
mkdir build\logs\checkout
mkdir build\logs\runtime
mkdir build\logs\sdk
mkdir build\logs\tests
java -Xmx1024m -jar %CC_HOME%\main\dist\cruisecontrol.jar %*

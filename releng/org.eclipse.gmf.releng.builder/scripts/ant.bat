@echo off
setlocal
set PROJECT_HOME=%~dp0
call %ANT_HOME%\bin\ant.bat %*
endlocal

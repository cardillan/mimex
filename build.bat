@echo off
call gradlew.bat jar
rem  --refresh-dependencies
copy build\libs\mimexDesktop.jar "%APPDATA%\Mindustry\mods\mimex-160.jar" /y

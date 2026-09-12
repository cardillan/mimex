@echo off
call gradlew.bat jar
copy build\libs\mimexDesktop.jar "%APPDATA%\Mindustry\mods\mimex-146.jar" /y

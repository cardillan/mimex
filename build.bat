@echo off
call gradlew.bat jar
copy build\libs\mimexDesktop.jar "%APPDATA%\Mindustry\mods\mimexDesktop6.jar" /y
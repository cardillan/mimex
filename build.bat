@echo off
call gradlew.bat jar
copy build\libs\mimexDesktop.jar "%APPDATA%\Mindustry\mods\mimexDesktop7.jar" /y
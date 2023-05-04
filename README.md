# Mindustry Metadata Extractor

A support tool for [Mindcode](https://github.com/cardillan/mindcode).

This mod loads into a Mindustry game, reads metadata information from runtime environment and stores them into text 
file(s) in game directory. These files then must be manually copied into the Mindcode project.   

## Building for Desktop Extraction

1. Install JDK **17**.
2. Run `gradlew jar` [1].
3. The `mimexDesktop.jar` will be in the `build/libs` directory. **Only use this version for obtaining metaga on 
   desktop. It will not work with Android.**

## Other notes

There's no need to build or run this mod on other platforms. 

--- 

*[1]* *On Linux/Mac it's `./gradlew`, but if you're using Linux I assume you know how to run executables properly anyway.*  


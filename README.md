# Sokoban

## Documentation

The project uses javadoc for commenting the code. The build process is automated by Gradle.
To access the documentation, you can open this file in a web browser : `app/build/docs/javadoc/index.html` .
Don't forget to run the Gradle task `./gradlew javadoc` !

## Gradle

### Working

The project uses Gradle as an automation tool. Everything is done via command line in the source directory. 
To use Gradle, refers as the section below and use theses commands in a terminal.

The main files are stored in `app/src/main/java/sokoban` .
The resources files (maps, textures, sound...) are stored in `app/src/main/resources` .

Java dependencies are handled by Gradle, they are automatically downloaded from mavenCentral repository. You should add them in the `app/build.gradle` file following [this guide](https://docs.gradle.org/current/userguide/declaring_dependencies.html). You can find dependencies at [maven.org](https://search.maven.org/).

Gradle also handle documentation via javadoc. You can find the documentation by opening `app/build/docs/javadoc/index.htm` in a web browser.

### Gradle tasks

- `./gradlew -q clean` clean the build folder
- `./gradlew -q build` build the project
- `./gradlew -q run` run the main app
- `./gradlew test` run the tests
- `./gradlew -q javadoc` generate javadoc
- :warning: `-q` is not mandatory. It's only used to remove the output in the console so Gradle won't flood your terminal.

## Tools

### MapChecker
You can use the Gradle task `./gradlew checkMap` with some parameters.
To pass arguments in a Gradle task you have to use `--args="arg1 arg2..."` .
These arguments will be split at each whitespaces, resulting in an array of strings containing `["arg1", "arg2", ...]` .

The result of the check will be printed in the console. Please avoid using `-q` parameter for Gradle since it's removes the output and you will not see the result of this tool.  

Parameters :
* `f` | file
* `d` | directory

Exemple:

- `./gradlew checkMap --args="f app/build/resources/main/levels/map1.xsb"` | check if a map1.xsb file is valid.
- `./gradlew checkMap --args="d app/build/resources/main/levels/"` | check if all the .xsb files in `levels/` are valid.

### Move Replay
You can use the Gradle task `./gradlew movReplay` with some parameters.
To pass arguments in a Gradle task you have to use `--args="arg1 arg2..."` .
These arguments will be split at each whitespaces, resulting in an array of strings containing `["arg1", "arg2", ...]` .

The result will be printed in the console and a new .xsb will be created in build/resources/main/levels/save/). Please avoid using `-q` parameter for Gradle since it's removes the output and you will not see the result of this tool.

Parameters :
* `map.xsb` | name of the original map (build/resources/main/levels/)
* `movements.mov` | name of the move file (build/resources/main/appdata/movements/)

Exemples :
`./gradlew movReplay -args="ma1.xsb mov1.xsb"` 

## Dependencies
### ffmpeg
On Unix systems, you have to install ffmpeg manually.  
https://ffmpeg.org/

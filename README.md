# Sokoban

## Documentation

The project uses javadoc for commenting the code. The build process is automated by Gradle.
To access the documentation, you can open this file in a web browser : `app/build/docs/javadoc/index.html`

## Gradle

### Working

The project uses Gradle as an automation tool. Everything is done via command line in the source directory. 
To use Gradle, refers as the section below and use theses commands in a terminal.

The main files are stored in `app/src/main/java/sokoban` .
The resources files (maps, textures, sound...) are stored in `app/src/main/resources` .

Dependencies are handled by Gradle, they are automatically downloaded from mavenCentral repository. You should add them in the `app/build.gradle` file following the existing pattern. You can find dependencies at [maven.org](https://search.maven.org/).

Gradle also handle documentation via javadoc. You can find the documentation by opening `app/build/docs/javadoc/index.htm` in a web browser.

### Gradle tasks

- `./gradlew clean` to clean the build folder.
- `./gradlew build` to build the project.
- `./gradlew run` to run the main app if you want to test it.
- `./gradlew javadoc` to generate javadoc.

# Crafty Builder
Simple & Lightweight library to allow the usage of the Builder Design Pattern for simple Spigot & Paper Components.

### Gradle :
````groovy
repositories {
    mavenCentral()
    maven {
        name = "AtlasRepo"
        url = 'https://repository.atlasworld.fr/repository/maven-public/'
    }
}

dependencies {
    implementation "be.raft.crafty:crafty-builder:${minecraft_version}-${crafty_version}"
}
````
Define ``minecraft_version`` and ``crafty_version`` in your gradle.properties file, 
or simply replace them with the correct version.
Versions available [here](https://github.com/Raft08/CraftyBuilder/releases)
### Maven : 
````xml
<repositories>
    <repository>
        <id>AtlasRepo</id>
        <url>https://repository.atlasworld.fr/repository/maven-public/</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>be.raft.crafty</groupId>
        <artifactId>crafty-builder</artifactId>
        <version>minecraft_version-crafty_version</version>
    </dependency>
</dependencies>
````
Replace ``minecraft_version`` and ``crafty_version`` with the correct version.
Versions available [here](https://github.com/Raft08/CraftyBuilder/releases)

## Usage:
See [Test Plugin](https://github.com/Raft08/CraftyBuilder/tree/master/plugin/src/main/java/be/raft/crafty/plugin) for examples.
Code is fully documented, see the javadoc for method listing.
### ItemBuilder
````java
    public static final ItemStack MY_CUSTOM_ITEM = ItemBuilder.create(Material.STICK)
        .displayName("My Custom Item")
        .amount(10)
        .setLore("This is the first line!", "This is the second line!")
        .loreAppender(append -> append.add("This is the thrird line!"))
        .build();
````

## Contributing:
Anybody can contribute by opening a [pull request](https://github.com/Raft08/CraftyBuilder/pulls).
I would really appreciate if you want to make this code base better! I don't have any code guidelines, 
I will just ask you to fully document your code.
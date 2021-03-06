package com.github.davidmoten.odata.client.generator;

import org.junit.Ignore;
import org.junit.Test;

public class OptionsGeneratorTest {

    @Test
    @Ignore
    public void overwriteOptions() {
        // when this test is run the Options class in src/main/java will be overwritten!
        com.github.davidmoten.javabuilder.Generator //
                .pkg("com.github.davidmoten.odata.client.generator") //
                .className("Options") //
                .type("String").name("outputDirectory")
                .defaultValue("\"target/generated-sources/odata\"").build() //
                .type("String").name("pkg").mandatory().build() //
                .type("String").name("packageSuffixEnum").defaultValue("\".enums\"").build() //
                .type("String").name("packageSuffixEntity").defaultValue("\".entity\"").build() //
                .type("String").name("packageSuffixComplexType").defaultValue("\".complex\"")
                .build() //
                .type("String").name("packageSuffixEntityRequest")
                .defaultValue("\".entity.request\"").build() //
                .type("String").name("packageSuffixCollectionRequest")
                .defaultValue("\".collection.request\"").build() //
                .type("String").name("packageSuffixContainer").defaultValue("\".container\"")
                .build() //
                .type("String").name("packageSuffixSchema").defaultValue("\".schema\"").build() //
                .type("String").name("simpleClassNameSchema").defaultValue("\"Schema\"").build() //
                .type("String").name("collectionRequestClassSuffix")
                .defaultValue("\"CollectionRequest\"").build() //
                .type("String").name("entityRequestClassSuffix").defaultValue("\"Request\"").build() //
                .type("boolean").name("pageComplexTypes").defaultValue("true").build() //
                .type("Map<String, String>").name("packageNamesByNamespace")
                .defaultValue("new HashMap<>()").build() //
                .generate("src/main/java/com/github/davidmoten/odata/client/generator");

    }

}

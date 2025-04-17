package org.acme.model;

import io.smallrye.common.constraint.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class PersonModel {
    @NotNull
    @Schema(required = true, example="Thet Htet Aung")
    public String name;

    @NotNull
    @Schema(required = true, example="26")
    public int age;

    public PersonModel() {}

}

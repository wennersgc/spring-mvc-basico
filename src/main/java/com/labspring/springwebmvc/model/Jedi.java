package com.labspring.springwebmvc.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Jedi {

    @NotBlank(message="Nome não pode ser em branco")
    @Size(min = 3, max = 20, message = "Nome tem que ter no minimo 3 caracteres e no máximo 30")
    private String name;

    @Size(max = 20, message = "Sobrenome tem que ter no máximo 20")
    private String lastName;

    public Jedi() {
    }

    public Jedi(String name, String lastName) {
        this.name = name;
        this.lastName  = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

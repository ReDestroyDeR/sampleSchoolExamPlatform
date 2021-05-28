package ru.red.sampleschoolexamplatform.model.exam;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class StringSet {
    private String set;

    public void setSet(Set<String> set) {
        this.set = "";
        set.forEach(s -> this.set += s.toString() + "//");
    }

    public Set<String> getSet() {
        return Arrays.stream(set.split("//")).collect(Collectors.toSet());
    }
}

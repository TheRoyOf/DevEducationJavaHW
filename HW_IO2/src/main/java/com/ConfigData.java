package com;

import java.util.Objects;

public class ConfigData{
    public String source;
    public String destination;
    public String props;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigData that = (ConfigData) o;
        return source.equals(that.source) &&
                destination.equals(that.destination) &&
                props.equals(that.props);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, props);
    }

    @Override
    public String toString() {
        return "ConfigData{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", props='" + props + '\'' +
                '}';
    }
}

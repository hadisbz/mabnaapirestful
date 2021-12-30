package ir.dotin.bigdata.project.mabnaapirestful.api.response;

import lombok.Value;

import java.util.List;

@Value
public class Root<T> {
    public List<T> data;
}

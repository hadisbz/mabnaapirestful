package ir.dotin.bigdata.project.mabnaapirestful.api.response;

import lombok.Value;

import java.util.List;

@Value
public class DataGenericResponse<T>{
    List<T> data;
}

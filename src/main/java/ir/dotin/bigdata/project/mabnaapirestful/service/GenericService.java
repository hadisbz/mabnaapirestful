package ir.dotin.bigdata.project.mabnaapirestful.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.DataGenericResponse;

public interface GenericService<T> {
    DataGenericResponse<T> response() throws JsonProcessingException;
}

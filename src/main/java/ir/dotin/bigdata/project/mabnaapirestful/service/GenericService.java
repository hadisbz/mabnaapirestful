package ir.dotin.bigdata.project.mabnaapirestful.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.Root;

public interface GenericService<T> {
    Root<T> response() throws JsonProcessingException;
}

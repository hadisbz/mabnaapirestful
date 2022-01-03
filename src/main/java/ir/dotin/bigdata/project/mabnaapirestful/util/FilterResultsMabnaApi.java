package ir.dotin.bigdata.project.mabnaapirestful.util;

import lombok.Getter;

public class FilterResultsMabnaApi {
    public static String filterByCountAndOptionalSkip(Integer count, Integer skip) {
        StringBuilder filterString = new StringBuilder();
        if (count != null) {
            filterString.append("_count=").append(count);

            if (skip != null)
                filterString.append("&_skip=").append(skip);

        }
        return filterString.toString();
    }

    public static String filterByIdAndOptionalOperation(String id, String idOp) {
        StringBuilder filterString = new StringBuilder("");
        if ((id != null && !id.isEmpty())) {
            filterString.append("id=").append(id);

            if ((idOp != null && !idOp.isEmpty()))
                filterString.append("&id_op=").append(idOp);
        }
        return filterString.toString();
    }
}

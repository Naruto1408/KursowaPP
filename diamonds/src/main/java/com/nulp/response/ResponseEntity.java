package com.nulp.response;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ResponseEntity {

    private Map<String, Object> responseHolder;

    public ResponseEntity() {
        responseHolder = new HashMap<>();
    }

    public void addPair(String key, Object value) {
        responseHolder.put(key, value);
    }

    public void deletePair(String key) {
        responseHolder.remove(key);
    }

    public Map<String, Object> getResponse() {
        return responseHolder;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> stringObjectEntry : responseHolder.entrySet()) {
            sb.append(stringObjectEntry.getKey()).append(" {").append(System.lineSeparator());
            if(stringObjectEntry.getValue() instanceof Collection<?>) {
                for (Object o : ((Collection<?>) stringObjectEntry.getValue())) {
                    sb.append("\t").append(o).append(System.lineSeparator());
                }
            }else
                sb.append("\t").append(stringObjectEntry.getValue()).append(System.lineSeparator());
            sb.append("}");
        }
        return sb.toString();
    }
}

package com.tom.example.hibernate.utils;

import javax.persistence.Query;
import java.util.List;

public class Utils {
    @SuppressWarnings("unchecked")
    public static <T> List<T> listAndCast(Query q) {
        return q.getResultList();
    }
}

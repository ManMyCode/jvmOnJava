package com.wangzhen.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Datetime:    2020/10/22   10:46
 * Author:   王震
 */
public class TestObject {
    String name ;
    String age;

    @Override
    public boolean equals(Object o) {
        List list = new ArrayList<>();
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestObject that = (TestObject) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return age != null ? age.equals(that.age) : that.age == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }
}
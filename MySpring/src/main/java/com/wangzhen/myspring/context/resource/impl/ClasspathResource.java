package com.wangzhen.myspring.context.resource.impl;

import com.wangzhen.myspring.context.resource.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Description:
 * Datetime:    2020/11/2   12:54
 * Author:   王震
 */
public class ClasspathResource implements Resource {
    @Override
    public boolean isExist() {
        return false;
    }

    @Override
    public File getFile() {
        return null;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return null;
    }
}